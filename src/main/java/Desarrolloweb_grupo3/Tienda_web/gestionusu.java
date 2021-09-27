package Desarrolloweb_grupo3.Tienda_web;

import java.io.IOException;
import java.io.PrintWriter;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnagregar")!=null) {
        try {
        	long cedula = Long.parseLong(request.getParameter("txtcedula"));
    		String nombre = request.getParameter("txtnombre");
    		String correo = request.getParameter("txtcorreo");
    		String user = request.getParameter("txtusuario");
            String password = request.getParameter("txtpass");
            int rol = 1;
            UsuarioDTO usuario = new UsuarioDTO();
            usuario.setCedula(cedula);
            usuario.setNombres(nombre);
            usuario.setEmail(correo);
            usuario.setUsuario(user);
            usuario.setPass(password);
            usuario.setNivel(rol);
            usuariodao.registrarEstudiante(usuario);
           
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, e);
        	
        }  
        PrintWriter out = response.getWriter();
        out.println ("<HTML>");			
		out.println ("<BODY>");			
		out.println ("<script>alert('Se agrego el usuario')</script>");
		out.println ("<script>window.location.href='Usuarios.jsp';</script>");
		out.println ("</body>");}
    }
		
	

}
