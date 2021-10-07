<%@page import="Desarrolloweb_grupo3.DAO.ProveedorDAO" %>
<%@page import="Desarrolloweb_grupo3.DTO.ProveedoresDTO" %>
<%@page import="Desarrolloweb_grupo3.DAO.ProductoDAO" %>
<%@page import="Desarrolloweb_grupo3.DTO.ProductosDTO" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    	<title>Actualizacion de Productos</title>
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
                    <h2 class="section-heading text-uppercase">Actualizar Productos</h2>
                </div>
                </div>
                <form  action ="<%=request.getContextPath()%>/gestionprodu" method="POST" >
                    <div class="row align-items-stretch mb-5">
                        <div class="col-md-6">
                        <div class="algo">
                         <%
                        long codigo = Long.parseLong(request.getParameter("codigo"));
                        ProductosDTO prod = ProductoDAO.buscarProducto(codigo);
                        %>
                                 <input class="form-control"  name="txtcodigo" type="text" placeholder="Codigo Producto" value = "<%=prod.getCodigo_producto()%>" hidden/>
                                <br>
                                <input class="form-control"  name="txtiva" type="text" placeholder="% de Iva" value = "<%=prod.getIva_compra()%>" required/>
                                <br>
                                <select class="form-control" name="txtnitproveedor">
                                   <%
						               List<ProveedoresDTO> listar = ProveedorDAO.buscarProveedores();
						                for (ProveedoresDTO pro : listar)
						                {
						                	%>     	
                                 <option value="<%=pro.getNit_proveedor()%>"><%=pro.getNombre_proveedor() %></option>
                                   <% }  %>	
						                </select>
                                <br>
                                <input class="form-control"  name="txtnombres" type="text" placeholder="Nombre" value = "<%=prod.getNombre_producto()%>"required/>
                                <br>
                                <input class="form-control"  name="txtpreciocom" type="text" placeholder="Precio Compra" value = "<%=prod.getPrecio_compra()%>"required/>
                                <br>
                                <input class="form-control"  name="txtprecioven" type="text" placeholder="Precio Venta" value = "<%=prod.getPrecio_venta()%>"required/>
                             <br>
                            </div>
                          </div>
                        </div>
                    <div class="text-center">
                    <input class="btn btn-primary btn-xl text-uppercase"  type="submit"  name="btnmodificar" value="Modificar"> 
                    <input class="btn btn-primary btn-xl text-uppercase"  type="submit"  name="btnconsultar" value="Consultar">      
                    </div></form>
                <br>
          
        </section> 
</body>
</html>