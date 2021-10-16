package Desarrolloweb_grupo3.Tienda_web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Desarrolloweb_grupo3.DAO.LectorCSV;
import Desarrolloweb_grupo3.DTO.ProductosDTO;

/**
 * Servlet implementation class cargaArchivo
 */
@WebServlet("/cargaArchivo")
public class cargaArchivo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private LectorCSV lectorCSV;
	 
	 public void init() {
		 lectorCSV = new LectorCSV(',',',');
	 }
       
   
    public cargaArchivo() {
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
		 
		if(request.getParameter("btnsubir")!=null) {
			try {
			String nombre = null;
	        List<ProductosDTO> producto = new ArrayList<ProductosDTO>();
	            nombre = request.getParameter("archivo");
	            producto = lectorCSV.leerCSVSimple(nombre);
	            PrintWriter out = response.getWriter();	
	            out.println ("<script>alert('Se Modifico el producto de forma correcta')</script>");
	    		out.println ("<script>window.location.href='Productos.jsp';</script>");
	        } catch (Exception e) {
	             e.printStackTrace();
	        }
	            
	           	            
		}
	}

}
