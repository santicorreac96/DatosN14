package mundo;

public class Restaurante
{
	
	private String nombre;
	
	private String ciudad;
	
	private String estado;

	private String ID;
	
	private String postal;
	
	private String direccion;
	
	private String telefono;
	
	private String fax;
	
	private String latitud;
	
	private String longitud;
	
	private String barrio;
	
	private String web;
	
	private String email;
	
	private String categoria;
	
	private String horario;
	
	private String cocina;

	public Restaurante(String nombre, String ciudad, String estado, String direccion, String post, String telefono, String fax, String latitud, String longitud, String barrio, String web, String email, String categoria, String horario, String cocina) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.estado = estado;
		this.direccion = direccion;
		postal = post;
		this.telefono = telefono;
		this.fax = fax;
		this.latitud = latitud;
		this.longitud = longitud;
		this.barrio = barrio;
		this.web = web;
		this.email = email;
		this.categoria = categoria;
		this.horario = horario;
		this.cocina = cocina;
		ID = this.nombre+"-"+this.ciudad+"-"+this.estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getID() {
		return ID;
	}
	
	public String toString ()
	{
		return ID;
	}
	
	
}
