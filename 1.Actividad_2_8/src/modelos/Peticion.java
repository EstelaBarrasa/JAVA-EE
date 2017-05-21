package modelos;

/**
 * representa una peticion de una pagina
 * @author usuario
 *
 */
public class Peticion {

	public static final int id=1;
	
	/**
	 * numero de peticiones
	 */
	private int n;
	
	/**
	 * inicializa n a 0
	 */
	public Peticion(){
		this.n=0;
	}
	
	public int getN(){
		return n;
	}
	
	public void setN(int n){
		this.n=n;
	}
}
