package modelos;

public class Viaje {

	
	private int id;
	private String destino;
	private String duracion;
	private double precio;
	
	public Viaje(){
		
	}
	
	public Viaje(int id,String destino, String duracion, double precio){
		this.id=id;
		this.destino=destino;
		this.duracion=duracion;
		this.precio=precio;
	}


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public boolean equals(Object o){
		if(o==null ) return false;
		else if(!(o instanceof Viaje))return false;
		else{
			Viaje a=(Viaje)o;
			return a.id==id;
		}
	}
}
