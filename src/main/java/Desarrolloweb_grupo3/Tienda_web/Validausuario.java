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


@WebServlet("/Validausuario")
public class Validausuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UsuarioDAO login;
    
    public void init () {
    	login = new UsuarioDAO();
    }
    public Validausuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("txtusuario");
        String password = request.getParameter("txtpass");
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setUsuario(user);
        usuario.setPass(password);
        try {
            if (login.validarusuario(usuario)) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario",user);
                response.sendRedirect("Admin.jsp");
            } else {
            	PrintWriter out = response.getWriter();  
            	response.setContentType("text/html");  
            	out.println("<script type=\"text/javascript\">");  
            	out.println("alert('Por favor verifique el usuario');");  
            	out.println("</script>");
            	response.sendRedirect("Login.jsp");
            	
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
		
    }
	

}
