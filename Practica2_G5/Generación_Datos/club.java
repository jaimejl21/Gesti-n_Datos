package GestionDatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class club {

	public static void generarClubes(String [] clubes) throws IOException {
		FileReader fr = new FileReader("C:\\Users\\raul2\\Desktop\\Segundo cuatri\\Entornos\\Eclipse\\algoritmos\\clubes.txt");
		BufferedReader bf = new BufferedReader(fr);
		String linea;
		int aux=0;
		while ((linea = bf.readLine())!=null) {
			  
			clubes[aux]=linea;
			aux++;
			}
	}
	public static void generarTrofeos(List <trofeos> trofeos) throws IOException {
		FileReader fr = new FileReader("C:\\Users\\raul2\\Desktop\\Segundo cuatri\\Entornos\\Eclipse\\algoritmos\\trofeos.txt");
		BufferedReader bf = new BufferedReader(fr);
		String linea;
		
		while ((linea = bf.readLine())!=null) {
			  for(int i=2016;i<=2021;i++) {
				  trofeos aux= new trofeos(linea,i);
				  trofeos.add(aux);
			  }
			}
		bf.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String [] clubes=new String[100];
		List<trofeos> trofeos = new ArrayList<trofeos>();
		generarClubes(clubes);
		generarTrofeos(trofeos);
		for(int i=0;i<=99;i++) {
			System.out.println("	<club nombreC='"+clubes[i].replaceAll(" ", "")+"'>");
			System.out.println("		<trofeos>");
			for(int j=1;j<=(int)Math.floor(Math.random()*(3-1+1)+1);j++) {
				int trofeoRandom=(int)Math.floor(Math.random()*((trofeos.size()-1)-1+1)+1);	
				System.out.println("			<trofeo edicion='"+trofeos.get(trofeoRandom).getEdicion()+"' nombreTrofeo='"+trofeos.get(trofeoRandom).getNombre()+"'/>");
				trofeos.remove(trofeoRandom);
				}
			System.out.println("		</trofeos>");
			System.out.println("	</club>");
			}
	}

}
