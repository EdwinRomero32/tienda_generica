<%@page import="Desarrolloweb_grupo3.DAO.UsuarioDAO"%>
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
                        <li class="nav-item"><a class="nav-link" href="Productos.jsp">Gestión Clientes</a></li>
                        <li class="nav-item"><a class="nav-link" href="Productos.jsp">Gestión Productos</a></li>
                        <li class="nav-item"><a class="nav-link" href="Contactenos.jsp">Gestión Proveedores</a></li>
                        <li class="nav-item"><a class="nav-link" href="Productos.jsp">Ventas</a></li>
                           <li class="nav-item"><a class="nav-link" href="index.jsp">Salir</a></li>
                    </ul>
                </div>
            </div>
        </nav>
         <section class="page-section" id="contact">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Gestión de Usuarios</h2>
                </div>
                </div>
                <form id="login" action ="<%=request.getContextPath()%>/gestionusu" method="POST" autocomplete = "off">
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
                             <input class="form-control" type="text" list="roles" name="txtrol" placeholder="Rol" />
									  <datalist id="roles">
									    <option value="Administrador">Administrador</option>
									  </datalist>
                    			 <br>
                            </div>
                          </div>
                        </div>
                    <div class="text-center">
                    <input class="btn btn-primary btn-xl text-uppercase"  type="submit"  name="btnagregar" value="Agregar">
                    <input class="btn btn-primary btn-xl text-uppercase"  type="submit"  name="btnconsultar" value="Consultar">							
                    <input class="btn btn-primary btn-xl text-uppercase"  type="submit"  name="btnmodificar" value="Modificar">
                    <input class="btn btn-primary btn-xl text-uppercase"  type="submit"  name="btneliminar" value="Eliminar">
                    </div>
                </form>
                
           
        </section>
        <%
        if(request.getParameter("btnagregar")!=null){
        	%>
        	<script type="text/javascript">alert("Se Agrego Usuario Correctamente");</script>
        	<%
        }
        	%>
</body>
</html>