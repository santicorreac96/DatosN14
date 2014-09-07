package mundo;

public class Categoria 
{
	private int cantidad;
	private String nombre;
	public Categoria(int cantidad, String nombre) {
		super();
		this.cantidad = cantidad;
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad() {
		this.cantidad ++;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void bajarCantidad() {
		// TODO Auto-generated method stub
		this.cantidad --;
	}
	
}
