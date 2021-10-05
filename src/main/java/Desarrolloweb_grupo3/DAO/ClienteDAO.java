package Desarrolloweb_grupo3.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Desarrolloweb_grupo3.DTO.ClientesDTO;
import Desarrolloweb_grupo3.DTO.ProveedoresDTO;

public class ClienteDAO {
	
	public boolean registrarCliente(ClientesDTO cliente) {
		try {
			Conexion conn = new Conexion();
			PreparedStatement ps = null;
			String consulta = "INSERT INTO clientes (cedula_cliente, direccion_cliente, email_cliente, nombres_cliente, telefono_cliente) values (?,?,?,?,?)";
			ps = conn.getConnection().prepareStatement(consulta);
			ps.setLong(1, cliente.getCedula_cliente());
			ps.setString(2, cliente.getDireccion_cliente());
			ps.setString(3, cliente.getEmail_cliente());
			ps.setString(4, cliente.getNombres_cliente());
			ps.setLong(5, cliente.getTelefono_cliente());
			ps.execute();
			ps.close();
			conn.desconectar();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean actualizarCliente(ClientesDTO cliente) {
		try {
			Conexion conn = new Conexion();
			PreparedStatement ps = null;
			String consulta = "UPDATE clientes SET direccion_cliente = ?, email_cliente = ?, nombres_cliente = ?, telefono_cliente = ? WHERE cedula_cliente = ?";
			ps = conn.getConnection().prepareStatement(consulta);
			ps.setString(1, cliente.getDireccion_cliente());
			ps.setString(2, cliente.getEmail_cliente());
			ps.setString(3, cliente.getNombres_cliente());
			ps.setLong(4, cliente.getTelefono_cliente());
			ps.setLong(5, cliente.getCedula_cliente());
			ps.execute();
			ps.close();
			conn.desconectar();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static ArrayList<ClientesDTO> buscarClientes(){
    	ArrayList <ClientesDTO> listaclientes = new ArrayList<ClientesDTO>();
    	try {
        Conexion conn = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String consulta = "select * from clientes";
        	ps = conn.getConnection().prepareStatement(consulta);
            rs = ps.executeQuery();
            while(rs.next()) {
            	ClientesDTO cli = new ClientesDTO();
            	 cli.setCedula_cliente(rs.getLong(1));
            	 cli.setDireccion_cliente(rs.getString(2));
            	 cli.setEmail_cliente(rs.getString(3));
            	 cli.setNombres_cliente(rs.getString(4));
            	 cli.setTelefono_cliente(rs.getLong(5)); 
            	 listaclientes.add(cli);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return listaclientes;  
    }
	
	public boolean eliminarcliente(long cedula) throws SQLException {
    	try{
    	PreparedStatement ps = null;
        Conexion conn = new Conexion();
        String consulta = "DELETE FROM clientes WHERE cedula_cliente = ?";
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
	
	public static ClientesDTO buscarCliente(long cedula) {
    	ClientesDTO cli = new ClientesDTO();
    	try {
    		PreparedStatement ps = null;
            Conexion conn = new Conexion();
            String consulta = "Select * FROM clientes WHERE cedula_cliente = ?";
            ps = conn.getConnection().prepareStatement(consulta);
            ps.setLong(1, cedula);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	 cli.setCedula_cliente(rs.getLong(1));
            	 cli.setDireccion_cliente(rs.getString(2));
            	 cli.setEmail_cliente(rs.getString(3));
            	 cli.setNombres_cliente(rs.getString(4));
            	 cli.setTelefono_cliente(rs.getLong(5)); 
            }
    	}catch(Exception e){
            	e.printStackTrace();
            }
		return cli;
   }
}
