package GestionDatos;

public class trofeos {
private String nombre;
private int edicion;

public trofeos(String nombreS, int edicionS) {
	nombre=nombreS;
	edicion=edicionS;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getEdicion() {
	return edicion;
}
public void setEdicion(int edicion) {
	this.edicion = edicion;
}
}
