package mundo;

import estructuraDatos.IListaEncadenadaDoble;

public interface IConsultorRestaurantes
{
	
	/**
	 * Metodo que permite cargar los restaurantes
	 */
	public abstract void cargarXLS();
	
	/**
	 * Metodo que permite buscar restaurantes por un identificador
	 * @param id el identificador de busqueda
	 * @return Una lista con los restaurantes que tiene el identificador dado
	 */
	public abstract IListaEncadenadaDoble<Restaurante> buscarPorIdentidicadorCompuesto(String id);
	
	/**
	 * Metodo que permite buscar restaurantes por region y/o ciudad
	 * @param estado el estado que se busca tenga el restaurante
	 * @param ciudad la ciudad que se busca tenga el restaurante
	 * @return Una lista con los restaurantes en la ciudad y/o estado dados
	 */
	public abstract IListaEncadenadaDoble<Restaurante> buscarPorLocacion(String estado, String ciudad);
	
	/**
	 * Metodo que permite regustrar un usuario
	 * @param pUser El usuario a registrar
	 * @throws Exception Si ya existe un usuario con la informacion dada
	 */
	public abstract void registrarUsuario(String pUser, String pPass, String nNombre, String nApellido, String nCedula,String nMail) throws Exception;
	
	/**
	 * Metodo que retorna el usuario que esta usando el directorio
	 * @return el usuario usando el directorio
	 */
	public abstract Usuario darUsuarioActual();
	
	/**
	 * Metodo que permite borra un restaurante dado su identificador
	 * @param id el identificador del restaurante a borrar
	 */
	public abstract void eliminarRestaurante(String id)throws Exception;

}
