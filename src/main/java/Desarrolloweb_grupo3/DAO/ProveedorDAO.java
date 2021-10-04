package Desarrolloweb_grupo3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Desarrolloweb_grupo3.DTO.ProveedoresDTO;


public class ProveedorDAO {
	
	public boolean registrarproveedor(ProveedoresDTO proveedor) {
		try {
			Conexion conn = new Conexion();
			PreparedStatement ps = null;
			String consulta = "INSERT INTO proveedores (nit_proveedor, ciudad_proveedor, direccion_proveedor, nombres_proveedor, telefono_proveedor) values (?,?,?,?,?)";
			ps = conn.getConnection().prepareStatement(consulta);
			ps.setLong(1, proveedor.getNit_proveedor());
			ps.setString(2, proveedor.getCiudad_proveedor());
			ps.setString(3, proveedor.getDireccion_proveedor());
			ps.setString(4, proveedor.getNombre_proveedor());
			ps.setLong(5, proveedor.getTelefono_proveedor());
			ps.execute();
			ps.close();
			conn.desconectar();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean actualizarProveedor(ProveedoresDTO proveedor) {
		try {
			Conexion conn = new Conexion();
			PreparedStatement ps = null;
			String consulta = "UPDATE proveedores SET ciudad_proveedor = ?, direccion_proveedor = ?, nombres_proveedor = ?, telefono_proveedor= ? WHERE nit_proveedor=?";
			ps = conn.getConnection().prepareStatement(consulta);
			ps.setString(1, proveedor.getCiudad_proveedor());
			ps.setString(2, proveedor.getDireccion_proveedor());
			ps.setString(3, proveedor.getNombre_proveedor());
			ps.setLong(4, proveedor.getTelefono_proveedor());
			ps.setLong(5, proveedor.getNit_proveedor());
			ps.execute();
			ps.close();
			conn.desconectar();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	 public static ArrayList<ProveedoresDTO> buscarProveedores(){
	    	ArrayList <ProveedoresDTO> listaproveedores = new ArrayList<ProveedoresDTO>();
	    	try {
	        Conexion conn = new Conexion();
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String consulta = "select * from proveedores";
	        	ps = conn.getConnection().prepareStatement(consulta);
	            rs = ps.executeQuery();
	            while(rs.next()) {
	            	ProveedoresDTO pro = new ProveedoresDTO();
	            	 pro.setNit_proveedor(rs.getLong(1));
	            	 pro.setCiudad_proveedor(rs.getString(2));
	            	 pro.setDireccion_proveedor(rs.getString(3));
	            	 pro.setNombre_proveedor(rs.getString(4));
	            	 pro.setTelefono_proveedor(rs.getLong(5)); 
	            	 listaproveedores.add(pro);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return listaproveedores;  
	    }
	 
	 public boolean eliminarProveedor(long nit) throws SQLException {
	    	try{
	    	PreparedStatement ps = null;
	        Conexion conn = new Conexion();
	        String consulta = "DELETE FROM proveedores WHERE nit_proveedor = ?";
	            ps = conn.getConnection().prepareStatement(consulta);
	            ps.setLong(1,nit);
	            ps.execute();
	            ps.close();
	        	conn.desconectar();
	            return true;
	        }catch (SQLException e){
	            e.printStackTrace();
	            return false; 
	        }
	    }
	 
	 public static ProveedoresDTO buscarProveedor(long nit) {
	    	ProveedoresDTO Pro = new ProveedoresDTO();
	    	try {
	    		PreparedStatement ps = null;
	            Conexion conn = new Conexion();
	            String consulta = "Select * FROM proveedores WHERE nit_proveedor = ?";
	            ps = conn.getConnection().prepareStatement(consulta);
	            ps.setLong(1, nit);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()) {
	            	Pro.setNit_proveedor(rs.getLong(1));
	            	Pro.setCiudad_proveedor(rs.getString(2));
	            	Pro.setDireccion_proveedor(rs.getString(3));
	            	Pro.setNombre_proveedor(rs.getString(4));
	            	Pro.setTelefono_proveedor(rs.getLong(5));
	            }
	    	}catch(Exception e){
	            	e.printStackTrace();
	            }
			return Pro;
	   }
}
