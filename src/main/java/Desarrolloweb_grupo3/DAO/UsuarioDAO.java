package Desarrolloweb_grupo3.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Desarrolloweb_grupo3.DTO.UsuarioDTO;

public class UsuarioDAO {

	public boolean validarusuario (UsuarioDTO usuario){
		 
	      boolean logeo = false;
	     
	      try{
	    	  Conexion conn = new Conexion();
			  PreparedStatement ps = null;
		      ResultSet rs = null;
		      String consulta = "SELECT usuario,pass_usuario FROM usuarios WHERE usuario = ? and pass_usuario = ?";
	            ps = conn.getConnection().prepareStatement(consulta);
	            ps.setString(1,usuario.getUsuario());
	            ps.setString(2, usuario.getPass());
	            rs = ps.executeQuery();
	            	logeo = rs.next();	            	
	            	rs.close();
	            	ps.close();
	            	conn.desconectar();
	        }catch (Exception e){
	           JOptionPane.showMessageDialog(null,"Verifique los datos del usuario");
	        }
		return logeo;
	}
	
	public boolean registrarEstudiante (UsuarioDTO usuario) {
		Conexion conn = new Conexion();
        PreparedStatement ps = null;
        String consulta = "INSERT INTO usuarios(cedula_usuario,email_usuario,nombre_usuario,pass_usuario,usuario,rol_usuario) VALUES(?,?,?,?,?,?)";
        try{
            ps = conn.getConnection().prepareStatement(consulta);
            ps.setLong(1,usuario.getCedula());
            ps.setString(2,usuario.getEmail());
            ps.setString(3,usuario.getNombres());
            ps.setString(4,usuario.getPass());
            ps.setString(5,usuario.getUsuario());
            ps.setInt(6,usuario.getNivel());
            ps.execute();
        	ps.close();
        	conn.desconectar();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
