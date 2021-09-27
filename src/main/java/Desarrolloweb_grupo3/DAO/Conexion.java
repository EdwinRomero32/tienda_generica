package Desarrolloweb_grupo3.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	static String basedatos = "tienda_generica";
    static String usuario = "root";
    static String pass = "NOeres56";
    static String ruta = "jdbc:mysql://localhost:3306/" + basedatos;
    Connection con = null;

    public  Conexion(){
        try{

           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection(ruta,usuario,pass);
           if(con != null) {
        	   System.out.println("Estas conectado");
           }
        }catch (SQLException | ClassNotFoundException e){
            System.out.println(e);

        }
       }
    
        public Connection getConnection() {
        	return con;
        }
        
        public void desconectar() {
        	con = null;
        }
        
    }


