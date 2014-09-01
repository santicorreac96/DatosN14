package mundo;

public class Restaurante
{
	
	private String nombre;
	
	private String ciudad;
	
	private String estado;

	private String ID;

	public Restaurante(String nombre, String ciudad, String estado) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.estado = estado;
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
	
	
	
}
