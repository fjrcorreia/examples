/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.java.ejb;

import java.util.ArrayList;
import sample.java.api.ServiceBeanRemote;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.java.api.model.User;
import sample.java.api.model.UserAttribute;
import sample.java.api.model.UserAttributeImpl;
import sample.java.api.model.UserImpl;
import sample.java.jpa.model.AttributeDao;
import sample.java.jpa.model.UserAttributeDao;
import sample.java.jpa.model.UserDao;

/**
 *
 * @author Francisco Correia {@literal <fjrcorreia@github.com>}
 */
//@Stateless(mappedName = "ServiceEJB", name = "ServiceBean", description = "Sample Remote EJB")
@Stateless
public class ServiceBean implements ServiceBeanRemote {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceBeanRemote.class);

    @PersistenceContext(unitName = "SAMPLE_PU")
    EntityManager em;

    public ServiceBean() {

        LOG.info("EntityManager: {}", em);
    }

    @Override
    public List<User> getUsers() {
        LOG.info("getUsers()-> EntityManager: {}", em);
        List<UserDao> users = em.createQuery("select u from users u", UserDao.class).getResultList();
        if (users.isEmpty()) {
            LOG.warn("No users to return");

            UserDao u = new UserDao("tony", "tony", "Tony Ramos");

            AttributeDao a1 = new AttributeDao("email", "String");
            AttributeDao a2 = new AttributeDao("phone", "String");

            em.persist(u);
            em.persist(a1);
            em.persist(a2);

            UserAttributeDao ua1 = new UserAttributeDao(u, a1, "email@dom.com");
            UserAttributeDao ua2 = new UserAttributeDao(u, a2, "12321376543");

            em.persist(ua1);
            em.persist(ua2);

            return Collections.emptyList();
        }

        List<User> resultList = new ArrayList<User>(users.size());
        for (UserDao u : users) {
            LOG.info(u.toString());
            resultList.add((User) new UserImpl(u.getName(), u.getDisplayName()));
        }

        return resultList;
    }

    @Override
    public List<UserAttribute> getUserAttributes(User user) {

        LOG.info("getUserAttributes()-> user: {}", user.getName());

        UserDao userDao = getUserByUsername(user);
        
        LOG.info("UserDao from user [{}]: {}", user.getName(), userDao);
        //LOG.info("User Attributes for [{}]: {}", user, userAttritubes.size());
        if (userDao == null){
        return Collections.emptyList();
        }
        
        List<UserAttributeDao> attributes = getUserAttributes(userDao);
        
        List<UserAttribute> result = new ArrayList<>();
        
        for (UserAttributeDao a : attributes){
            result.add(new UserAttributeImpl(a.getName(), a.getValue(), a.getType()));
        }
        
        return result;
    }

    
    
    
    
    private List<UserAttributeDao> getUserAttributes(UserDao user){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserAttributeDao> queryUserAttributes = builder.createQuery(UserAttributeDao.class);
        Root<UserAttributeDao> rootAttribute = queryUserAttributes.from(UserAttributeDao.class);
        queryUserAttributes.select(rootAttribute)
                .where(builder.equal(rootAttribute.get("user"), user));
        
        List<UserAttributeDao> attributesResult = em.createQuery(queryUserAttributes).getResultList();
        
        return attributesResult;
    }
    
    
    private UserDao getUserByUsername(User user) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserDao> queryUser = builder.createQuery(UserDao.class);
        Root<UserDao> rootUser = queryUser.from(UserDao.class);
        queryUser.select(rootUser)
                .where(builder.equal(rootUser.get("username"), user.getName()));
        
        List<UserDao> usersResult = em.createQuery(queryUser).getResultList();
        

        if (usersResult.isEmpty() || usersResult.size() > 1){
            return null;
        }
        
        return usersResult.get(0);
    }
}
