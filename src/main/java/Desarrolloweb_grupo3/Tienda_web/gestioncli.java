package Desarrolloweb_grupo3.Tienda_web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Desarrolloweb_grupo3.DAO.ClienteDAO;
import Desarrolloweb_grupo3.DTO.ClientesDTO;
import Desarrolloweb_grupo3.DTO.UsuarioDTO;

/**
 * Servlet implementation class gestioncli
 */
@WebServlet("/gestioncli")
public class gestioncli extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO clientedao;
	private ClientesDTO cliente;
	
	public void init() {
		clientedao = new ClienteDAO();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gestioncli() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long cedula = Long.parseLong(request.getParameter("cedula"));
		try {
			clientedao.eliminarcliente(cedula);
			PrintWriter out = response.getWriter();	
			out.println ("<script>alert('Se elimino el cliente correctamente')</script>");
	    	out.println ("<script>window.location.href='Clientes.jsp';</script>");

			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnagregar")!=null) {
			cliente = new ClientesDTO();
        try {
        	long cedula = Long.parseLong(request.getParameter("txtcedula"));
    		String direccion = request.getParameter("txtdireccion");
    		String correo = request.getParameter("txtemail");
    		String nombre = request.getParameter("txtnombres");
            long  telefono = Long.parseLong(request.getParameter("txttelefono"));
            cliente.setCedula_cliente(cedula);
            cliente.setDireccion_cliente(direccion);
            cliente.setEmail_cliente(correo);
            cliente.setNombres_cliente(nombre);
            cliente.setTelefono_cliente(telefono);
            clientedao.registrarCliente(cliente);

            PrintWriter out = response.getWriter();	
    		out.println ("<script>alert('Se agrego un cliente nuevo')</script>");
    		out.println ("<script>window.location.href='Clientes.jsp';</script>");
        }catch(Exception e) {
        	e.printStackTrace();
        		}
		}

		if(request.getParameter("btnmodificar")!=null) {
			cliente = new ClientesDTO();
	        try {
	    		String direccion = request.getParameter("txtdireccion");
	    		String correo = request.getParameter("txtemail");
	    		String nombre = request.getParameter("txtnombres");
	            long  telefono = Long.parseLong(request.getParameter("txttelefono"));
	            long cedula = Long.parseLong(request.getParameter("txtcedula"));
	            cliente.setCedula_cliente(cedula);
	            cliente.setDireccion_cliente(direccion);
	            cliente.setEmail_cliente(correo);
	            cliente.setNombres_cliente(nombre);
	            cliente.setTelefono_cliente(telefono);
	            cliente.setCedula_cliente(cedula);
	            clientedao.actualizarCliente(cliente);
	            PrintWriter out = response.getWriter();	
	            out.println ("<script>alert('Se Modifico el cliente')</script>");
	    		out.println ("<script>window.location.href='Clientes.jsp';</script>");
				}catch(Exception e) {
        	e.printStackTrace();
        		}
		}
	
		if(request.getParameter("btnconsultar")!=null) {
			try {
					clientedao.buscarClientes();
					 PrintWriter out = response.getWriter();	
			    		out.println ("<script>window.location.href='Clientes.jsp';</script>");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }  
			}
		
	}

}
