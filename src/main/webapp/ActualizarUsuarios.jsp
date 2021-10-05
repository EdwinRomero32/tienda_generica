<%@page import="Desarrolloweb_grupo3.DAO.UsuarioDAO"%>
<%@page import="Desarrolloweb_grupo3.DTO.UsuarioDTO"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    	<title>Actualizacion Usuarios</title>
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
                        <li class="nav-item"><a class="nav-link" href="Proveedores.jsp">Gestión Proveedores</a></li>
                        <li class="nav-item"><a class="nav-link" href="Productos.jsp">Ventas</a></li>
                           <li class="nav-item"><a class="nav-link" href="index.jsp">Salir</a></li>
                    </ul>
                </div>
            </div>
        </nav>
         <section class="page-section" id="contact">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Actualización de Usuarios</h2>
                </div>
                </div>
                <form id="login" action ="<%=request.getContextPath()%>/gestionusu" method="POST">
                    <div class="row align-items-stretch mb-5">
                        <div class="col-md-6">
                        <div class="algo">
                        <%
                        long cedula = Long.parseLong(request.getParameter("cedula"));
                        UsuarioDTO usu = UsuarioDAO.buscarUsuario(cedula);
                        %>
                                <input class="form-control"  name="txtcedula2" type="text" value="<%=usu.getCedula() %>" hidden/>
                                <br>
                                <input class="form-control"  name="txtnombre2" type="text" value="<%=usu.getNombres() %>" required/>
                                <br>
                                <input class="form-control"  name="txtcorreo2" type="email" value="<%=usu.getEmail() %>" required/>
                                <br>
                                <input class="form-control"  name="txtusuario2" type="text" value="<%=usu.getUsuario() %>" required/>
                                <br>
                                <input class="form-control"  name="txtpass2" type="password" value="<%=usu.getPass()%>" required/>
                             <br>
                            </div>
                          </div>
                        </div>
                    <div class="text-center">  
                    <input class="btn btn-primary btn-xl text-uppercase"  type="submit"  name="btnconsultar" value="Consultar">							
                    <input class="btn btn-primary btn-xl text-uppercase"  type="submit"  name="btnmodificar" value="Modificar">                   
                    </div>  
                <br>
         	 </form>
        </section>   
</body>
</html>