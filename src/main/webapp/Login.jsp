<%@page import="Desarrolloweb_grupo3.DAO.UsuarioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page session = "true" %>
 

<!DOCTYPE html>
<html lang="en">
    <head>
    	<title>Login</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <link href="css/styles.css" rel="stylesheet" />
         <link href="css/estilo.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand"><img src="assets/img/logos/logo.png" alt="..." /></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ms-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                       
                        <li class="nav-item"><a class="nav-link" href="Contactenos.jsp">Contactenos</a></li>
                    </ul>
                </div>
            </div>
        </nav>
  <section class="page-section" id="contact">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Acceso de Usuarios</h2>
                    <h3 class="section-subheading text-muted">Por favor registre sus datos</h3>
                </div>
                </div>
                <form id="login" action ="<%=request.getContextPath()%>/Validausuario" method="POST">
                    <div class="row align-items-stretch mb-5">
                        <div class="col-md-6">
                            <div class="form-group">
                               <div class="algo">
                                
                                <input class="form-control" id="name" name="txtusuario" type="text" placeholder="Escriba su usuario" required/>
                                <br>
                                <input class="form-control" id="pass" name="txtpass" type="password" placeholder="Ingrese su contraseña" required/>
                                 <br>
                    			 <br>
                            </div>
                          </div>
                        </div>
                       
                    </div>
                    </div>
                    <div class="text-center"><input class="btn btn-primary btn-xl text-uppercase" id="submitButton" type="submit"  name="btniniciar" value="Iniciar Sesión"></div>
                </form>
                
           
        </section>
		
</body>
</html>