package Desarrolloweb_grupo3.Tienda_web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Desarrolloweb_grupo3.DAO.ProductoDAO;
import Desarrolloweb_grupo3.DTO.ProductosDTO;
import Desarrolloweb_grupo3.DTO.ProveedoresDTO;

/**
 * Servlet implementation class gestionprodu
 */
@WebServlet("/gestionprodu")
public class gestionprodu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductosDTO producto;
	private ProductoDAO productodao;
	
	public void init() {
		productodao = new ProductoDAO();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gestionprodu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long codigo = Long.parseLong(request.getParameter("codigo"));
		try {
			productodao.eliminarProducto(codigo);
			PrintWriter out = response.getWriter();	
	    	out.println ("<script>alert('Se elimino el producto')</script>");
	    	out.println ("<script>window.location.href='Productos.jsp';</script>");

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnagregar")!=null) {
			producto = new ProductosDTO();
        try {
        	long codigo = Long.parseLong(request.getParameter("txtcodigo"));
    		double iva = Double.parseDouble(request.getParameter("txtiva"));
    		long nit = Long.parseLong(request.getParameter("txtnitproveedor"));
    		String nombre = request.getParameter("txtnombres");
            double precioc = Double.parseDouble(request.getParameter("txtpreciocom"));
            double preciov = Double.parseDouble(request.getParameter("txtprecioven"));
            producto.setCodigo_producto(codigo);
            producto.setIva_compra(iva);
            producto.setNit_proveedor(nit);
            producto.setNombre_producto(nombre);
            producto.setPrecio_compra(precioc);
            producto.setPrecio_venta(preciov);
            productodao.registrarProducto(producto);
            PrintWriter out = response.getWriter();	
    		out.println ("<script>alert('Se agrego un nuevo producto a la base de datos')</script>");
    		out.println ("<script>window.location.href='Productos.jsp';</script>");
        }catch(Exception e) {
        	e.printStackTrace();
        		}
		}
	
	
	if(request.getParameter("btnmodificar")!=null) {
		producto = new ProductosDTO();
        try {
        	long codigo = Long.parseLong(request.getParameter("txtcodigo"));
    		double iva = Double.parseDouble(request.getParameter("txtiva"));
    		long nit = Long.parseLong(request.getParameter("txtnitproveedor"));
    		String nombre = request.getParameter("txtnombres");
            double precioc = Double.parseDouble(request.getParameter("txtpreciocom"));
            double preciov = Double.parseDouble(request.getParameter("txtprecioven"));
            producto.setIva_compra(iva);
            producto.setNit_proveedor(nit);
            producto.setNombre_producto(nombre);
            producto.setPrecio_compra(precioc);
            producto.setPrecio_venta(preciov);
            producto.setCodigo_producto(codigo);
            productodao.actualizarProducto(producto);
            PrintWriter out = response.getWriter();	
            out.println ("<script>alert('Se Modifico el producto de forma correcta')</script>");
    		out.println ("<script>window.location.href='Productos.jsp';</script>");
			}catch(Exception e) {
    	e.printStackTrace();
    		}
	}
	
	if(request.getParameter("btnconsultar")!=null) {
		try {
				productodao.buscarProductos();
				 PrintWriter out = response.getWriter();	
		    		out.println ("<script>window.location.href='Productos.jsp';</script>");
        } catch (Exception ex) {
            ex.printStackTrace();
        }  
		}
	}
}
