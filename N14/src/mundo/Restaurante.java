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
	
	private int pos;

	public Restaurante(String nombre, String ciudad, String estado, String direccion, String post, String telefono, String fax, String latitud, String longitud, String barrio, String web, String email, String categoria, String horario, String cocina,int pos) {
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
		this.pos = pos;
		ID = this.nombre+"-"+this.ciudad+"-"+this.estado;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
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

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getCocina() {
		return cocina;
	}

	public void setCocina(String cocina) {
		this.cocina = cocina;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getID() {
		return ID;
	}
	
	public String toString ()
	{
		return ID;
	}
	
	
}
