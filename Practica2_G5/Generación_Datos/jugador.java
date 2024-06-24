package GestionDatos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class jugador {
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
	public static void generarClubes(String [] clubes) throws IOException {
		FileReader fr = new FileReader("C:\\Users\\raul2\\Desktop\\Segundo cuatri\\Entornos\\Eclipse\\algoritmos\\clubes.txt");
		BufferedReader bf = new BufferedReader(fr);
		String linea;
		int aux=0;
		while ((linea = bf.readLine())!=null) {
			  
			clubes[aux]=linea;
			aux++;
			}
		bf.close();
	}
	public static void generarCuentas(String [] cuentas) throws IOException {
		FileReader fr = new FileReader("C:\\Users\\raul2\\Desktop\\Segundo cuatri\\Entornos\\Eclipse\\algoritmos\\cuentasOrigin.txt");
		BufferedReader bf = new BufferedReader(fr);
		String linea;
		int aux=0;
		while ((linea = bf.readLine())!=null) {
			  
			cuentas[aux]=linea;
			aux++;
			}
		bf.close();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String [] jugadores=new String[100];
		String [] clubes=new String[100];
		String [] cuentasOrigin=new String[100];
		generarUsuarios(jugadores);
		generarClubes(clubes);
		generarCuentas(cuentasOrigin);
		
		for(int i=0;i<=99;i++) {
			System.out.println("	<jugador idJug='"+jugadores[i].replaceAll(" ", "")+"'>");
			System.out.println("		<division>"+(int)Math.floor(Math.random()*(10-1+1)+1)+"</division>");
			System.out.println("		<monedas>"+(int)Math.floor(Math.random()*(100-50+1)+50)+"</monedas>");
			if((int)Math.floor(Math.random()*(2-0+1)+0)>0){
			System.out.println("		<cuentaOrigin>"+cuentasOrigin[i].replaceAll(" ","")+"</cuentaOrigin>");
			}
			if((int)Math.floor(Math.random()*(3-0+1)+0)>0){
				int club=(int)Math.floor(Math.random()*(49-0+1)+0);
			System.out.println("		<club>"+clubes[club]+"</club>");
			}
			System.out.println("	</jugador>");
		}
	}

}
