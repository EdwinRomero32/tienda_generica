package Desarrolloweb_grupo3.Tienda_web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Desarrolloweb_grupo3.DAO.ProveedorDAO;
import Desarrolloweb_grupo3.DTO.ProveedoresDTO;
import Desarrolloweb_grupo3.DTO.UsuarioDTO;

/**
 * Servlet implementation class gestionpro
 */
@WebServlet("/gestionpro")
public class gestionpro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProveedoresDTO  proveedor;
	private ProveedorDAO proveedordao;
	
    public void init() {
    	proveedordao = new ProveedorDAO();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gestionpro() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long nit = Long.parseLong(request.getParameter("nit"));
		try {
			proveedordao.eliminarProveedor(nit);
			PrintWriter out = response.getWriter();	
	    	out.println ("<script>alert('Se elimino el proveedor')</script>");
	    	out.println ("<script>window.location.href='Proveedores.jsp';</script>");

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnagregar")!=null) {
			proveedor = new ProveedoresDTO();
        try {
        	long nit = Long.parseLong(request.getParameter("txtnit"));
    		String ciudad = request.getParameter("txtciudad");
    		String direccion = request.getParameter("txtdireccion");
    		String nombre = request.getParameter("txtnombres");
            long telefono = Long.parseLong(request.getParameter("txttelefono"));
            proveedor.setNit_proveedor(nit);
            proveedor.setCiudad_proveedor(ciudad);
            proveedor.setDireccion_proveedor(direccion);
            proveedor.setNombre_proveedor(nombre);
            proveedor.setTelefono_proveedor(telefono);
            proveedordao.registrarproveedor(proveedor); 
            PrintWriter out = response.getWriter();	
    		out.println ("<script>alert('Se agrego un nuevo proveedor a la base de datos')</script>");
    		out.println ("<script>window.location.href='Proveedores.jsp';</script>");
        }catch(Exception e) {
        	e.printStackTrace();
        		}
		}
		
		
		if(request.getParameter("btnmodificar")!=null) {
			proveedor = new ProveedoresDTO();
			try {
				long nit = Long.parseLong(request.getParameter("txtnit2"));
	    		String ciudad = request.getParameter("txtciudad2");
	    		String direccion = request.getParameter("txtdireccion2");
	    		String nombre = request.getParameter("txtnombres2");
	            long telefono = Long.parseLong(request.getParameter("txttelefono2"));
	            proveedor.setCiudad_proveedor(ciudad);
	            proveedor.setDireccion_proveedor(direccion);
	            proveedor.setNombre_proveedor(nombre);
	            proveedor.setTelefono_proveedor(telefono);
	            proveedor.setNit_proveedor(nit);
	            proveedordao.actualizarProveedor(proveedor);
	            PrintWriter out = response.getWriter();	
	            out.println ("<script>alert('Se Modifico el proveedor de forma correcta')</script>");
	    		out.println ("<script>window.location.href='Proveedores.jsp';</script>");
				}catch(Exception e) {
        	e.printStackTrace();
        		}
		}
		
		if(request.getParameter("btnconsultar")!=null) {
			try {
					proveedordao.buscarProveedores();
					 PrintWriter out = response.getWriter();	
			    		out.println ("<script>window.location.href='Proveedores.jsp';</script>");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }  
			}
		
	}

}
