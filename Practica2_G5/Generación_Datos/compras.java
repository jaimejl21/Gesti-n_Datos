package GestionDatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class compras {
public static void generarUsuarios(String [] usuarios) throws IOException {
	FileReader fr = new FileReader("C:\\Users\\raul2\\Desktop\\Segundo cuatri\\Entornos\\Eclipse\\algoritmos\\jugadores.txt");
	BufferedReader bf = new BufferedReader(fr);
	String linea;
	int aux=0;
	while ((linea = bf.readLine())!=null) {
		  
		usuarios[aux]=linea;
		aux++;
		}
	bf.close();
}
public static void generarArticulos(String [] articulos) throws IOException {
	FileReader fr = new FileReader("C:\\Users\\raul2\\Desktop\\Segundo cuatri\\Entornos\\Eclipse\\algoritmos\\articulos.txt");
	BufferedReader bf = new BufferedReader(fr);
	String linea;
	int aux=0;
	while ((linea = bf.readLine())!=null) {
		  
		articulos[aux]=linea;
		aux++;
		}
	bf.close();
}
public static void generarIdCompras(String[] compras) {

	for(int i=0;i<=99;i++) {
		if(i<9) {
			compras[i]="compra-00"+(i+1);
		}
		else if(i>=9&&i<=98) {
			compras[i]="compra-0"+(i+1);
		}
		else {
			compras[i]="compra-"+(i+1);
		}
	}
}

public static String devolverTipo(int indice) {
	if(indice<=16) {
		return "Baile";
	}
	else if(indice<=38) {
		return "Mejora";
	}
	else {
		return "Estadio";
	}
}
public static int precios(int indice) {
	if(indice<=16) {
		return 5;
	}
	else if(indice<=38) {
		return 10;
	}
	else {
		return 7;
	}
}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String [] usuarios=new String[100];
		String [] articulos=new String[52];
		String [] idCompra=new String[100];
		generarUsuarios(usuarios);
		generarArticulos(articulos);
		generarIdCompras(idCompra);
		List<String> objetosComprados = new ArrayList<String>();
		
		for(int i=0;i<=99;i++) {
		System.out.println("<compra idCompra='"+idCompra[i]+"'>");
		System.out.println("	<usuario>"+usuarios[(int)Math.floor(Math.random()*(99-0+1)+0)].replaceAll(" ","")+
				"</usuario>");
		for(int j=0;j<=(int)Math.floor(Math.random()*(5-1+1)+1);j++) {
			
			int indiceArticulo=(int)Math.floor(Math.random()*(51-0+1)+0);
			String articuloComprado=articulos[indiceArticulo];
			String tipoArticulo=devolverTipo(indiceArticulo);
			
			if(!objetosComprados.contains(articuloComprado)) {
				objetosComprados.add(articuloComprado);
				int cantidad=(int)Math.floor(Math.random()*(10-1+1)+1);
				int precio=precios(indiceArticulo);
				System.out.println("	<articulo>");
				System.out.println("		<nombreArticulo>"+articuloComprado+"</nombreArticulo>");
				System.out.println("		<tipoArticulo>"+tipoArticulo+"</tipoArticulo>");
				System.out.println("		<cantidad>"+cantidad+"</cantidad>");
				System.out.println("		<precio>"+(cantidad*precio)+"</precio>");
				System.out.println("	</articulo>");
			}
		}
		System.out.println("</compra>");
		objetosComprados.clear();
			
		}
	}

}
