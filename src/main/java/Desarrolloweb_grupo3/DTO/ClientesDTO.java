package Desarrolloweb_grupo3.DTO;

public class ClientesDTO {
	
	private long cedula_cliente;
	private String direccion_cliente;
	private String email_cliente;
	private String nombres_cliente;
	private long telefono_cliente;
	public long getCedula_cliente() {
		return cedula_cliente;
	}
	public void setCedula_cliente(long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	public String getDireccion_cliente() {
		return direccion_cliente;
	}
	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}
	public String getEmail_cliente() {
		return email_cliente;
	}
	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	public String getNombres_cliente() {
		return nombres_cliente;
	}
	public void setNombres_cliente(String nombres_cliente) {
		this.nombres_cliente = nombres_cliente;
	}
	public long getTelefono_cliente() {
		return telefono_cliente;
	}
	public void setTelefono_cliente(long telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}
	
	

}
