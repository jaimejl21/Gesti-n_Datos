package GestionDatos;

public class equipo {
	public String nombre;
	public String liga;
	public String pais;
	public int id;
	
	public equipo(String n,String p,String l) {
		nombre=n;
		pais=p;
		liga=l;
	}
	public equipo() {
		
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLiga() {
		return liga;
	}

	public void setLiga(String liga) {
		this.liga = liga;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	

}
