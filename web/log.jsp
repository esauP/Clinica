<%@ page language="java" import="java.util.*, data.*, pojo.*" %>
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

         <div id="content">
            <table summary ="Listado de Profesores"  cellSpacing="1" cellPadding="8" width="770" align="center" border="0">
                <tr valign ="middle" align="center">
                  
                    <%
                        DetalleUsuario det = new DetalleUsuario();
                        List<Usuario> usuarios = det.AllUsuarios();
                    %>
                    <td id = "colchones" colspan="8"><b>Usuarios registrados</b></td> 
                </tr>
                <tr valign=" middle" align="center" id="cabecera">
                    <td>Nombre</td><td>Contraseña</td><td>Observaciones</td><td>Seleccionar</td>
                </tr>

                <%  for (Iterator iter = usuarios.iterator(); iter.hasNext();) {
                    Usuario u = (Usuario) iter.next();
                %>
                <tr align="center" id="Usuarios"> 
                    <td><%=u.getUsuario()%></td>
                    <td> <%=u.getPass()%> </td>
                    <td> <%=u.getObservaciones()%> </td>
                    <td> <a href="FrontController?res=tutorias.jsp?pid=<%=u.getUsuario()%>&name=<%=u.getPass()%>"><img src='img/seleccionar.gif'> </a></td>		 				
                </tr>
                <%
                        }
                    
                %>

            </table>

        </div>
    </body>
</hmtl>
  