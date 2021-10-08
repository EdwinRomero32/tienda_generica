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
    	<title>Gestion Productos</title>
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
                    <h2 class="section-heading text-uppercase">Agregar Productos</h2>
                </div>
                </div>
                <form  action ="<%=request.getContextPath()%>/gestionprodu" method="POST" >
                    <div class="row align-items-stretch mb-5">
                        <div class="col-md-6">
                        <div class="algo">
                                <input class="form-control"  name="txtcodigo" type="text" placeholder="Codigo Producto" required/>
                                <br>
                                <input class="form-control"  name="txtiva" type="text" placeholder="% de Iva" required/>
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
                                <input class="form-control"  name="txtnombres" type="text" placeholder="Nombre" required/>
                                <br>
                                <input class="form-control"  name="txtpreciocom" type="text" placeholder="Precio Compra" required/>
                                <br>
                                <input class="form-control"  name="txtprecioven" type="text" placeholder="Precio Venta" required/>
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
				<th>Codigo</th>
				<th>Nombre</th>
				<th>Proveedor</th>
				<th>Precio Compra</th>
				<th>Precio Venta</th>
				<th>Iva</th>
				<th></th>
				<th></th>
				</tr>
	                <%
	               List<ProductosDTO> lista = ProductoDAO.buscarProductos();
	                for (ProductosDTO prod : lista)
	                {
	                	%>
	                	<script type="text/javascript">
						    function borra(){
						    	var eli = confirm("Desea borrar este producto?");
						    	if(eli){
						    		window.location.href="gestionprodu?codigo=<%=prod.getCodigo_producto()%>";
						    	}else{
						    		alert("No se hicieron cambios");
						    	}
						    }
						</script>
                  <tr>
                  	<td><%=prod.getCodigo_producto() %></td>
                  	<td><%=prod.getNombre_producto()%></td>
                  	<td><%=prod.getNombre_proveedor()%></td>
                  	<td>$<%=prod.getPrecio_compra()%></td>
                  	<td>$<%=prod.getPrecio_venta()%></td>
                  	<td><%=prod.getIva_compra()%> %</td>
                  	<td><a class="botones" href="ActualizarProductos.jsp?codigo=<%=prod.getCodigo_producto()%>">Modificar</a></td>
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