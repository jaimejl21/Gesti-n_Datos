package GestionDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class servidor {

	public static void generarServidores(String [] servidores) {
		for(int i=0;i<=99;i++) {
			if(i<9) {
				servidores[i]="sv-00"+(i+1);
			}
			else if(i>=9&&i<=98) {
				servidores[i]="sv-0"+(i+1);
			}
			else {
				servidores[i]="sv-"+(i+1);
			}
			
		}
	}
	public static void generarSalas(String [] salas) {
		
		for(int i=0;i<=199;i++) {
			salas[i]="s"+(i+1);
		}
	}
	public static void generarPaises(String [] paises) throws IOException{
		
		FileReader fr = new FileReader("C:\\Users\\raul2\\Desktop\\Segundo cuatri\\Entornos\\Eclipse\\algoritmos\\paises.txt");
		BufferedReader bf = new BufferedReader(fr);
		String linea;
		int aux=0;
		while ((linea = bf.readLine())!=null) {
			   //System.out.println(linea);
			paises[aux]=linea;
			aux++;
			}
		bf.close();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String [] servidores=new String [100]; 
		String [] salas=new String [200]; 
		String [] paises= new String [100];
		generarPaises(paises);	
		generarServidores(servidores);
		generarSalas(salas);
	
		int aux=0;
		for(int i=0;i<=99;i++){
			System.out.println("<servidor id='"+servidores[i]+"'>");
			System.out.println("	<region><![CDATA["+paises[i]+"]]></region>");
			System.out.println(" 	<salas>");
			for(int j=0;j<=1;j++) {
				System.out.println("		<sala>"+salas[aux]+"</sala>");
			aux++;
			}
			System.out.println("	</salas>");
			System.out.println("</servidor>");
			
		}
	}

}
