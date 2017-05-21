package modelos;

/**
 * un usuario de la aplicacion
 * @author usuario
 *
 */
public class Usuario {

	/**
	 * identificador del usuario
	 */
	private String id;
	
	/**
	 * id identificador del usuario
	 * @param id
	 */
	public Usuario(String id){
		this.id=id;
	}
	
	public String getId(){
		return id;
	}
}
