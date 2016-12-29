

<%@page import="sample.java.api.model.UserAttribute"%>
<%@page import="sample.java.api.model.User"%>
<jsp:useBean id="bean" class="sample.java.web.SampleBean" scope="session"/>

<!DOCTYPE html>
<html>
    <head>
        <title>SAmple Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Hello Sample World!</h1>
        
        <h2>Users</h2>
        <%
            for (User u : bean.getUsers()){
                
                %>
                <p><b><%=u.getName()%></b></p>
                <%
                    for (UserAttribute a : bean.getUserAttributes(u)){
                        %>
                        <p>  -- [<%=a.getType()%>]<%=a.getName()%>:<%=a.getValue()%></p>
                        <%
                    }
            }
        %>
        
    </body>
</html>
