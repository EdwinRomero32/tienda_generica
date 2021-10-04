package Desarrolloweb_grupo3.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
	
	public boolean registrarUsuario (UsuarioDTO usuario) {
		try{
			Conexion conn = new Conexion();
			PreparedStatement ps = null;
			String consulta = "INSERT INTO usuarios(cedula_usuario,email_usuario,nombre_usuario,pass_usuario,usuario) VALUES(?,?,?,?,?)";
			ps = conn.getConnection().prepareStatement(consulta);
            ps.setLong(1,usuario.getCedula());
            ps.setString(2,usuario.getEmail());
            ps.setString(3,usuario.getNombres());
            ps.setString(4,usuario.getPass());
            ps.setString(5,usuario.getUsuario());
            ps.execute();
        	ps.close();
        	conn.desconectar();
            return true;
        	}catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
	
	public boolean modificarUsuario(UsuarioDTO usuario) {
		try{
			Conexion conn = new Conexion();
			PreparedStatement ps = null;
			String consulta = "UPDATE usuarios SET  email_usuario = ?, nombre_usuario = ?, pass_usuario = ?, usuario = ? where cedula_usuario = ?";
			ps = conn.getConnection().prepareStatement(consulta);
            ps.setString(1,usuario.getEmail());
            ps.setString(2,usuario.getNombres());
            ps.setString(3,usuario.getPass());
            ps.setString(4,usuario.getUsuario());
            ps.setLong(5,usuario.getCedula());
            ps.execute();
        	ps.close();
        	conn.desconectar();
            return true;
        	}catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
		
    public static ArrayList<UsuarioDTO> buscarUsuarios(){
    	ArrayList <UsuarioDTO> listausuarios = new ArrayList<UsuarioDTO>();
    	
    	try {
        Conexion conn = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String consulta = "select * from usuarios";
        	ps = conn.getConnection().prepareStatement(consulta);
            rs = ps.executeQuery();
            while(rs.next()) {
            	UsuarioDTO usu = new UsuarioDTO();
            	 usu.setCedula(rs.getLong(1));
            	 usu.setNombres(rs.getString(2));
            	 usu.setEmail(rs.getString(3));
            	 usu.setPass(rs.getString(4));
            	 usu.setUsuario(rs.getString(5)); 
            	 listausuarios.add(usu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return listausuarios;  
    }
    
    public boolean eliminarUsuario(long cedula) throws SQLException {
    	try{
    	PreparedStatement ps = null;
        Conexion conn = new Conexion();
        String consulta = "DELETE FROM usuarios WHERE cedula_usuario = ?";
            ps = conn.getConnection().prepareStatement(consulta);
            ps.setLong(1,cedula);
            ps.execute();
            ps.close();
        	conn.desconectar();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false; 
        }
    }
   
    public static UsuarioDTO buscarUsuario(long cedula) {
    	UsuarioDTO Usu = new UsuarioDTO();
    	try {
    		PreparedStatement ps = null;
            Conexion conn = new Conexion();
            String consulta = "Select * FROM usuarios WHERE cedula_usuario = ?";
            ps = conn.getConnection().prepareStatement(consulta);
            ps.setLong(1, cedula);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	Usu.setCedula(rs.getLong(1));
            	Usu.setEmail(rs.getString(2));
            	Usu.setNombres(rs.getString(3));
            	Usu.setPass(rs.getString(4));
            	Usu.setUsuario(rs.getString(5));
            }
    	}catch(Exception e){
            	e.printStackTrace();
            }
		return Usu;
            }
    
}
