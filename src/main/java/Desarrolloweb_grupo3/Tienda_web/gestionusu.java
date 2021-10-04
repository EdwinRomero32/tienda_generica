package Desarrolloweb_grupo3.Tienda_web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Desarrolloweb_grupo3.DAO.UsuarioDAO;
import Desarrolloweb_grupo3.DTO.UsuarioDTO;

/**
 * Servlet implementation class gestionusu
 */
@WebServlet("/gestionusu")
public class gestionusu extends HttpServlet {
	private static final long serialVersionUID = 1L;
private UsuarioDAO usuariodao;
private UsuarioDTO usuario;
    
    public void init () {
    	usuariodao = new UsuarioDAO();
    	
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gestionusu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long cedula = Long.parseLong(request.getParameter("cedula"));
		try {
			usuariodao.eliminarUsuario(cedula);
			PrintWriter out = response.getWriter();	
			out.println ("<script>alert('Se elimino el usuario correctamente')</script>");
	    	out.println ("<script>window.location.href='Usuarios.jsp';</script>");

			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnagregar")!=null) {
			usuario = new UsuarioDTO();
        try {
        	long cedula = Long.parseLong(request.getParameter("txtcedula"));
    		String nombre = request.getParameter("txtnombre");
    		String correo = request.getParameter("txtcorreo");
    		String user = request.getParameter("txtusuario");
            String password = request.getParameter("txtpass");
            usuario.setCedula(cedula);
            usuario.setNombres(nombre);
            usuario.setEmail(correo);
            usuario.setUsuario(user);
            usuario.setPass(password);
            usuariodao.registrarUsuario(usuario); 
            PrintWriter out = response.getWriter();	
    		out.println ("<script>alert('Muy bien, se agrego el usuario')</script>");
    		out.println ("<script>window.location.href='Usuarios.jsp';</script>");
        }catch(Exception e) {
        	e.printStackTrace();
        		}
		}

		if(request.getParameter("btnmodificar")!=null) {
			usuario = new UsuarioDTO();
			try {
	    		String nombre = request.getParameter("txtnombre2");
	    		String correo = request.getParameter("txtcorreo2");
	    		String user = request.getParameter("txtusuario2");
	            String password = request.getParameter("txtpass2");
	            long cedula = Long.parseLong(request.getParameter("txtcedula2"));
	            usuario.setEmail(correo);
	            usuario.setNombres(nombre);
	            usuario.setUsuario(user);
	            usuario.setPass(password);
	            usuario.setCedula(cedula);
	            usuariodao.modificarUsuario(usuario);
	            PrintWriter out = response.getWriter();	
	            out.println ("<script>alert('Se Modifico el usiario')</script>");
	    		out.println ("<script>window.location.href='Usuarios.jsp';</script>");
				}catch(Exception e) {
        	e.printStackTrace();
        		}
		}
	
		if(request.getParameter("btnconsultar")!=null) {
			try {
					usuariodao.buscarUsuarios();
					 PrintWriter out = response.getWriter();	
			    		out.println ("<script>window.location.href='Usuarios.jsp';</script>");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }  
			}
		}
	}
	


