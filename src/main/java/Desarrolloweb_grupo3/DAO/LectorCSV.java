package Desarrolloweb_grupo3.DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Desarrolloweb_grupo3.DTO.ProductosDTO;
import Desarrolloweb_grupo3.DAO.ProductoDAO;

public class LectorCSV {
	private char separador;
    private char comillas;

    public LectorCSV(char separador, char comillas) {
        this.separador = separador;
        this.comillas = comillas;
    }
    
	// Métodos
	/**
	 * Lee un CSV que no contiene el mismo caracter que el separador en su texto
	 * y sin comillas que delimiten los campos
	 * @param path Ruta donde está el archivo
	 * @throws IOException 
	 */
	public List<ProductosDTO> leerCSVSimple(String path) throws IOException {
            // Abro el .csv en buffer de lectura
            BufferedReader bufferLectura = new BufferedReader(new FileReader(path));
            String linea = bufferLectura.readLine();// Leo una línea del archivo
            List<ProductosDTO> productos = new ArrayList<>(); // Crea una lista tipo Producto
            ProductoDAO productoDAO=new ProductoDAO();//Crear un objeto tipo producto DAO
            
            
            try {
                while (linea != null) {
                   
                    String[] campos = linea.split(String.valueOf(this.separador));
                    ProductosDTO pro = new ProductosDTO(); // Instanciamos un objeto tipo Proveedor
                    pro.setCodigo_producto(Long.parseLong(campos[0]));
                    pro.setIva_compra(Double.parseDouble(campos[1]));
                    pro.setNit_proveedor(Integer.parseInt(campos[2]));
                    pro.setNombre_producto(campos[3]);
                    pro.setPrecio_compra(Double.parseDouble(campos[4]));
                    pro.setPrecio_venta(Double.parseDouble(campos[5]));
                  	System.out.println(pro);
    	        
                   // productoDAO.registrarProducto(pro);
                   // productos.add(pro);
                    linea = bufferLectura.readLine();
                   
                }
                // CIerro el buffer de lectura
                if (bufferLectura != null) {
                    bufferLectura.close();
                }

            } catch (Exception e) {
                e.printStackTrace();}
            return productos;
	}

}
