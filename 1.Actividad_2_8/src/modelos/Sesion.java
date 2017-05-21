package modelos;

/**
 * representa una sesion
 * @author usuario
 *
 */
public class Sesion {

	/**
	 * identificador de la sesion. Coincide con el identificador del objeto sesion
	 */
	private String id;
	
	/**
	 * numero de accesos a la sesion
	 */
	private int n;
	
	/**
	 * id identificador de la sesion
	 * @param id
	 */
	public Sesion(String id){
		this.id=id;
		n=0;
	}
	
	public Sesion(String id, int n){
		this.id=id;
		this.n=n;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
}
