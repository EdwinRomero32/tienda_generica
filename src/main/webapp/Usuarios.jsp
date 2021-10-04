<%@page import="Desarrolloweb_grupo3.DAO.UsuarioDAO"%>
<%@page import="Desarrolloweb_grupo3.DTO.UsuarioDTO"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    	<title>Gestion Usuarios</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/estilo.css" rel="stylesheet" />
       
    </head>
    <body id="page-top">
    </script>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand"><img src="assets/img/logos/logo.png" alt="..." /></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ms-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                    	<li class="nav-item"><a class="nav-link" href="Usuarios.jsp">Gestión Usuarios</a></li>
                        <li class="nav-item"><a class="nav-link" href="Clientes.jsp">Gestión Clientes</a></li>
                        <li class="nav-item"><a class="nav-link" href="Productos.jsp">Gestión Productos</a></li>
                        <li class="nav-item"><a class="nav-link" href="Proveedores.jsp">Gestión Proveedores</a></li>
                        <li class="nav-item"><a class="nav-link" href="Ventas.jsp">Ventas</a></li>
                           <li class="nav-item"><a class="nav-link" href="index.jsp">Salir</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <section class="page-section" id="contact">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Agregar Usuarios</h2>
                </div>
                </div>
                <form  action ="<%=request.getContextPath()%>/gestionusu" method="POST" >
                    <div class="row align-items-stretch mb-5">
                        <div class="col-md-6">
                        <div class="algo">
                                <input class="form-control"  name="txtcedula" type="text" placeholder="Cedula" required/>
                                <br>
                                <input class="form-control"  name="txtnombre" type="text" placeholder="Nombre completo" required/>
                                <br>
                                <input class="form-control"  name="txtcorreo" type="email" placeholder="Correo" required/>
                                <br>
                                <input class="form-control"  name="txtusuario" type="text" placeholder="Usuario" required/>
                                <br>
                                <input class="form-control"  name="txtpass" type="password" placeholder="Contraseña" required/>
                             <br>
                            </div>
                          </div>
                        </div>
                    <div class="text-center">
                    <input class="btn btn-primary btn-xl text-uppercase"  type="submit"  name="btnagregar" value="Agregar"> 
                    <input class="btn btn-primary btn-xl text-uppercase"  type="reset"  name="btnagregar" value="Limpiar">      
                    </div></form>
                <br>
            <div id="contenidotabla" class="contabla">    
                <table style="border-color:white; border:2px;">
				<tr>
				<th>Cedula</th>
				<th>Correo</th>
				<th>Nombre</th>
				<th>Usuario</th>
				<th>Contraseña</th>
				<th></th>
				<th></th>
				</tr>
	                <%
	                List<UsuarioDTO> listar = UsuarioDAO.buscarUsuarios();
	                for (UsuarioDTO usu : listar)
	                {
	                	%>
	                    <script type="text/javascript">
						    function borra(){
						    	var eli = confirm("Desea borrar este usuario?");
						    	if(eli){
						    		window.location.href="gestionusu?cedula=<%=usu.getCedula()%>";
						    	}else{
						    		alert("No se hicieron cambios");
						    	}
						    }
						</script>
                  <tr>
                   <td><%=usu.getCedula()%></td>
                   <td><%=usu.getNombres()%></td>
                   <td><%=usu.getEmail()%></td>
                   <td><%=usu.getUsuario()%></td>
                   <td><%=usu.getPass()%></td>
                   <td><a class="botones" href="ActualizarUsuarios.jsp?cedula=<%=usu.getCedula() %>">Modificar</a></td>
                   <td><a class="botones" OnClick="borra();">Eliminar</a></td>
                 </tr>
                 <%
                }    
                %>	
                </table>
           </div>
        </section> 
</body>
</html>