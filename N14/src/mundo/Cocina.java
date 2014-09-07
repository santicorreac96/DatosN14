package mundo;

public class Cocina 
{
	
	private int cantidad;
	private String nombre;
	private String estado;
	public Cocina(int cantidad, String nombre, String estado)
	{
		super();
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.estado = estado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad() 
	{
		this.cantidad++;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void bajarCantidad() 
	{
		this.cantidad--;
	}

}
