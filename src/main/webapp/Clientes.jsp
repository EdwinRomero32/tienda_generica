<%@page import="Desarrolloweb_grupo3.DAO.ClienteDAO" %>
<%@page import="Desarrolloweb_grupo3.DTO.ClientesDTO" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    	<title>Gestion Clientes</title>
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
                    <h2 class="section-heading text-uppercase">Agregar Clientes</h2>
                </div>
                </div>
                <form  action ="<%=request.getContextPath()%>/gestioncli" method="POST" >
                    <div class="row align-items-stretch mb-5">
                        <div class="col-md-6">
                        <div class="algo">
                                <input class="form-control"  name="txtcedula" type="text" placeholder="Nit" required/>
                                <br>
                                <input class="form-control"  name="txtdireccion" type="text" placeholder="Ciudad" required/>
                                <br>
                                <input class="form-control"  name="txtemail" type="email" placeholder="Dirección" required/>
                                <br>
                                <input class="form-control"  name="txtnombres" type="text" placeholder="Nombre" required/>
                                <br>
                                <input class="form-control"  name="txttelefono" type="text" placeholder="Número de telefono" required/>
                             <br>
                            </div>
                          </div>
                        </div>
                    <div class="text-center">
                    <input class="btn btn-primary btn-xl text-uppercase"  type="submit"  name="btnagregar" value="Agregar"> 
                    <input class="btn btn-primary btn-xl text-uppercase"  type="reset"  name="limpiar" value="Limpiar">      
                    </div></form>
                <br>
            <div id="contenidotabla" class="contabla">    
                <table style="border-color:white; border:2px;">
				<tr>
				<th>Cedula</th>
				<th>Dirección</th>
				<th>Correo</th>
				<th>Nombres</th>
				<th>Telefono</th>
				<th></th>
				<th></th>
				</tr>
	                <%
	               List<ClientesDTO> listar = ClienteDAO.buscarClientes();
	                for (ClientesDTO cli : listar)
	                {
	                	%>
	                	<script type="text/javascript">
						    function borra(){
						    	var eli = confirm("Desea borrar este proveedor?");
						    	if(eli){
						    		window.location.href="gestioncli?cedula=<%=cli.getCedula_cliente()%>";
						    	}else{
						    		alert("No se hicieron cambios");
						    	}
						    }
						</script>
                  <tr>
                  	<td><%=cli.getCedula_cliente() %></td>
                  	<td><%=cli.getDireccion_cliente()%></td>
                  	<td><%=cli.getEmail_cliente()%></td>
                  	<td><%=cli.getNombres_cliente()%></td>
                  	<td><%=cli.getTelefono_cliente()%></td>
                  	<td><a class="botones" href="ActualizarProveedores.jsp?nit=<%=cli.getCedula_cliente()%>">Modificar</a></td>
                  	<td><a class="botones" onClick = "borra();">Eliminar</a></td>
                  	
                 </tr>
                 <%
                }    
                %>	
                </table>
           </div>
        </section> 
</body>
</html>