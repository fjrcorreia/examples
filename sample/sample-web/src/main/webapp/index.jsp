

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
            for (User u : bean.getUsers()) {

        %>
        <ul>
            <li><b><%=u.getName()%></b></li>
            <ul>
                <%
                    for (UserAttribute a : bean.getUserAttributes(u)) {
                %>
                <li>[<%=a.getType()%>]<%=a.getName()%>:<%=a.getValue()%></li>
                <%
                        }
                    }
                %>
            </ul>
        </ul>
    </body>
</html>
