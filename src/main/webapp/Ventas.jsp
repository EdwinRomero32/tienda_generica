<%@page import="Desarrolloweb_grupo3.DAO.UsuarioDAO" %>
<%@page import="Desarrolloweb_grupo3.DTO.UsuarioDTO" %>
<%@page import="Desarrolloweb_grupo3.DAO.ProductoDAO" %>
<%@page import="Desarrolloweb_grupo3.DTO.ProductosDTO" %>
<%@page import="Desarrolloweb_grupo3.DAO.ClienteDAO" %>
<%@page import="Desarrolloweb_grupo3.DTO.ClientesDTO" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page session = "true" %>
 

<!DOCTYPE html>
<html lang="en">
    <head>
    	<title>Ventas</title>
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
                       <li class="nav-item"><a class="nav-link" href="Usuarios.jsp">Gestión Usuarios</a></li>
                        <li class="nav-item"><a class="nav-link" href="Clientes.jsp">Gestión Clientes</a></li>
                        <li class="nav-item"><a class="nav-link" href="Productos.jsp">Gestión Productos</a></li>
                        <li class="nav-item"><a class="nav-link" href="Proveedores.jsp">Gestión Proveedores</a></li>
                        <li class="nav-item"><a class="nav-link" href="Ventas.jsp">Ventas</a></li>
                        <li class="nav-item"><a class="nav-link" href="Reportes.jsp">Reportes</a></li>
                    </ul>
                </div>
            </div>
        </nav>
  <section class="page-section" id="contact">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Venta</h2>
                    <h3 class="section-subheading text-muted">Modulo de facturación</h3>
                </div>
                </div>
                <form id="login" action ="<%=request.getContextPath()%>/gestionventas" method="POST">
                     <div id="contenidotabla" class="contabla"> 
                    <table>
                    <tr>
                    <th colspan=4 class="section-heading text-uppercase">Tienda generica</th>
                    </tr>
                     <tr>
                    <td colspan=2></td>
                   	<td>Número factura</td>
                   	<td>Fecha</td>
                   	</tr>
                   	<tr>
                   	<td colspan=2></td>
                   	<td><input class="form-control" type ="text" name="txtnumerofac" placeholder="Númnero de factura">
                   	<td><input class="form-control" type="date" name="txtfecha" placeholder="Fecha factura"></td>
                   	</tr><tr><td colspan=4></td></tr>
                   	
                   	<tr>
                   	<td colspan=2>Vendedor</td>
                    
                   <%
                   List<UsuarioDTO> listausu = UsuarioDAO.buscarUsuarios();
                    for (UsuarioDTO usu : listausu)
						                {
						                	%>    
                    <td colspan=2><select class="form-control" name="txtusuario">
                    <option value="<%=usu.getCedula()%>"><%=usu.getEmail() %></option> <%} %>
                    </select></td>
                    
                    </tr>
                    <tr>
                    <td colspan=2>Nombre cliente</td>
                     <% List<ClientesDTO> listacli = ClienteDAO.buscarClientes();
                    for (ClientesDTO cli : listacli)
						                {
						                	%>    
                    <td colspan=2><select class="form-control" name="txtcliente">
                    <option value="<%=cli.getCedula_cliente()%>"><%=cli.getNombres_cliente()%></option><%} %>
                    </select></td>
                    </tr>
                    <tr>
                    <th>Producto</th>
                    <th>Cantidad</th>
                    <th>Precio unitario</th>
                    <th>Precio total</th></tr>
                    <tr><td></td>
                    <td></td>
                    <td></td>
                    <td></td></tr>
                    <tr><td><select class="form-control" name="txtproducto">
                     <%
						              List<ProductosDTO> listapro = ProductoDAO.buscarProductos();
                     					
                     					
                     					
                     					
                    
                    
						                for (ProductosDTO prod : listapro)
						                {
						                	%>     	
                     <option value="<%=prod.getCodigo_producto()%>"><%=prod.getNombre_producto() %></option>
                                   <% }  %>
                    </select></td>
                    <td><input class="form-control" type ="number" name="txtcantidad" placeholder="Cantidad Producto"></td>
                    <td><input class="form-control" type ="text" name="txtprecio" placeholder="Precio Unitario" value="">	</td>
                     <td><input class="form-control" type ="text" name="txttotal" placeholder="Precio Total"></td></tr>
                     <tr><th colspan=4><input type=submit value="Agregar Detalle"></th></tr>
                     <tr><th colspan=4>Gracias por su compra</th></tr>
                     <tr><th colspan=2>Sub Total</th><th colspan=2><input  class="form-control" type="text" name="txtsubtotal" placeholder="Subtotal"></th></tr>
                      <tr><th colspan=2>Iva</th><th colspan=2><input  class="form-control" type="text" name="txtiva" placeholder="Iva"></th></tr>
                       <tr><th colspan=2>Total a pagar</th><th colspan=2><input  class="form-control" type="text" name="txttotal" placeholder="Total a pagar"></th></tr>
                     <tr><th colspan=4><input type=submit value="Factura"></th></tr>
                    </table>  
                    </div>
                </form>
                
           
        </section>
		
</body>
</html>