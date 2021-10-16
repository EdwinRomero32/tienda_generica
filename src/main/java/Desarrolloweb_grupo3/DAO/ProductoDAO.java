package Desarrolloweb_grupo3.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import Desarrolloweb_grupo3.DTO.ProductosDTO;
import Desarrolloweb_grupo3.DTO.ProveedoresDTO;

public class ProductoDAO {

	public boolean registrarProducto(ProductosDTO producto) {
		try {
			Conexion conn = new Conexion();
			PreparedStatement ps = null;
			String consulta = "INSERT INTO productos (codigo_producto, iva_compra, nit_proveedor, nombre_producto, precio_compra, precio_venta) values (?,?,?,?,?,?)";
			ps = conn.getConnection().prepareStatement(consulta);
			ps.setLong(1, producto.getCodigo_producto());
			ps.setDouble(2, producto.getIva_compra());
			ps.setLong(3, producto.getNit_proveedor());
			ps.setString(4, producto.getNombre_producto());
			ps.setDouble(5, producto.getPrecio_compra());
			ps.setDouble(6, producto.getPrecio_venta());
			ps.execute();
			ps.close();
			conn.desconectar();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean actualizarProducto(ProductosDTO producto) {
		try {
			Conexion conn = new Conexion();
			PreparedStatement ps = null;
			String consulta = "UPDATE productos SET iva_compra = ?, nit_proveedor = ?, nombre_producto = ?, precio_compra= ?, precio_venta = ? WHERE codigo_producto = ?";
			ps = conn.getConnection().prepareStatement(consulta);			
			ps.setDouble(1, producto.getIva_compra());
			ps.setLong(2, producto.getNit_proveedor());
			ps.setString(3, producto.getNombre_producto());
			ps.setDouble(4, producto.getPrecio_compra());
			ps.setDouble(5, producto.getPrecio_venta());
			ps.setLong(6, producto.getCodigo_producto());
			ps.execute();
			ps.close();
			conn.desconectar();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static ArrayList<ProductosDTO> buscarProductos(){
    	ArrayList <ProductosDTO> listaproductos = new ArrayList<ProductosDTO>();
    	try {
        Conexion conn = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String consulta = "select productos.*,proveedores.nombres_proveedor from productos inner join proveedores  on productos.nit_proveedor = proveedores.nit_proveedor";
        	ps = conn.getConnection().prepareStatement(consulta);
            rs = ps.executeQuery();
            while(rs.next()) {
            	ProductosDTO prod = new ProductosDTO();
            	 prod.setCodigo_producto(rs.getLong(1));
            	 prod.setIva_compra(rs.getDouble(2));
            	 prod.setNit_proveedor(rs.getLong(3));
            	 prod.setNombre_producto(rs.getString(4));
            	 prod.setPrecio_compra(rs.getDouble(5));
            	 prod.setPrecio_venta(rs.getDouble(6));
            	 prod.setNombre_proveedor(rs.getString(7));
            	 listaproductos.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return listaproductos;  
    }
	
	public boolean eliminarProducto(long codigo) throws SQLException {
    	try{
    	PreparedStatement ps = null;
        Conexion conn = new Conexion();
        String consulta = "DELETE FROM productos WHERE codigo_producto = ?";
            ps = conn.getConnection().prepareStatement(consulta);
            ps.setLong(1,codigo);
            ps.execute();
            ps.close();
        	conn.desconectar();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false; 
        }
    }
	
	 public static ProductosDTO buscarProducto(long codigo) {
	    	ProductosDTO Prod = new ProductosDTO();
	    	try {
	    		PreparedStatement ps = null;
	            Conexion conn = new Conexion();
	            String consulta = "Select * FROM productos WHERE codigo_producto = ?";
	            ps = conn.getConnection().prepareStatement(consulta);
	            ps.setLong(1, codigo);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()) {
	            	Prod.setCodigo_producto(rs.getLong(1));
	            	Prod.setIva_compra(rs.getDouble(2));
	            	Prod.setNit_proveedor(rs.getLong(3));
	            	Prod.setNombre_producto(rs.getString(4));
	            	Prod.setPrecio_compra(rs.getDouble(5));
	            	Prod.setPrecio_venta(rs.getDouble(6));
	            }
	    	}catch(Exception e){
	            	e.printStackTrace();
	            }
			return Prod;
	   }
	 
	 
	 
}

