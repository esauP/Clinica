<%@ page language="java" import="java.util.*;" %>
<!DOCTYPE HTML>
<hmtl>
    <body>
        <%
            String userForm = (String) session.getAttribute("session.user");
            if (userForm == null) {
                response.sendRedirect("error.html");
            }
        %>

        <h4>Bienvenido </h4>
        
        <b> <h1>Usuario</h1> <h1> <%=session.getAttribute("observaciones")%> </h1></b>

        
    </body>
</hmtl>
  