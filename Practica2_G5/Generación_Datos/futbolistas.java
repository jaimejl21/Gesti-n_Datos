package GestionDatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class futbolistas {
public static void generarId(String [] id) {
		for(int i=0;i<=99;i++) {
			if(i<9) {
				id[i]="f-00"+(i+1);
			}
			else if(i>=9&&i<=98) {
				id[i]="f-0"+(i+1);
			}
			else {
				id[i]="f-"+(i+1);
			}
		}
	}
public static void generarFutbolistas(String [] futbolistas) throws IOException {
	FileReader fr = new FileReader("C:\\Users\\raul2\\Desktop\\Segundo cuatri\\Entornos\\Eclipse\\algoritmos\\futbolistas.txt");
	BufferedReader bf = new BufferedReader(fr);
	String linea;
	int aux=0;
	while ((linea = bf.readLine())!=null) {
		  
		futbolistas[aux]=linea;
		aux++;
		}
	bf.close();
}
public static void generarEquipos(List <equipo> equipos) throws IOException{

	FileReader fr = new FileReader("C:\\Users\\raul2\\Desktop\\Segundo cuatri\\Entornos\\Eclipse\\algoritmos\\equiposJ.txt");
	BufferedReader bf = new BufferedReader(fr);
	String linea;
	int aux=0;
	equipo auxE= new equipo();
	while ((linea = bf.readLine())!=null) {
		 if(aux==0) {
			 auxE.setNombre(linea);
		 }
		 else if(aux==1) {
			 auxE.setPais(linea);
		 }
		 else {
			 auxE.setLiga(linea);
		 }
		 aux++;
		 if(aux==3) {
			 aux=0;
			 equipo aux2=new equipo(auxE.getNombre(),auxE.getPais(),auxE.getLiga());
			 equipos.add(aux2);
			 
			 
		 }
		}
	
	
}
	
public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String [] identificadores=new String[100];
		String [] futbolistas=new String[100];
		List<equipo> equipos = new ArrayList<equipo>();
		int idEquipo=0;
		int aux11=0;
		int media;
		int numCartas;
		int cartaRandom;
		generarId(identificadores);
		generarFutbolistas(futbolistas);
		generarEquipos(equipos);
		for(int i=0;i<=98;i++) {
		System.out.println("	<futbolista idF='"+identificadores[i]+"'>");
		System.out.println("		<nombre>"+futbolistas[i]+"</nombre>");
		System.out.println("		<equipo>");
		System.out.println("			<nombreEquipo>"+equipos.get(idEquipo).nombre+"</nombreEquipo>");
		System.out.println("			<pais>"+equipos.get(idEquipo).pais+"</pais>");
		System.out.println("			<liga>"+equipos.get(idEquipo).liga+"</liga>");
		System.out.println("		</equipo>");
		aux11++;
		if(aux11==11) {
			aux11=0;
			idEquipo++;
		}
		System.out.println("		<cartas>");

		System.out.println("			<carta tipoCarta='normal'>");
		media=(int)Math.floor(Math.random()*(91-83+1)+83);
		numCartas=(int)Math.floor(Math.random()*(2-0+1)+0);
		System.out.println("				<mediaCarta>"+media+"</mediaCarta>");
		System.out.println("			</carta>");
		if(numCartas==1) {
			cartaRandom=(int)Math.floor(Math.random()*(1-0+1)+0);
				if(cartaRandom==0) {
					System.out.println("			<carta tipoCarta='TOTY'>");
					System.out.println("				<mediaCarta>"+(media+8)+"</mediaCarta>");
					System.out.println("			</carta>");
				}
				else {
					System.out.println("			<carta tipoCarta='Destacados'>");
					System.out.println("				<mediaCarta>"+(media+4)+"</mediaCarta>");
					System.out.println("			</carta>");
				}
		}
		if(numCartas==2) {
			System.out.println("			<carta tipoCarta='TOTY'>");
			System.out.println("				<mediaCarta>"+(media+8)+"</mediaCarta>");
			System.out.println("			</carta>");
			System.out.println("			<carta tipoCarta='Destacados'>");
			System.out.println("				<mediaCarta>"+(media+4)+"</mediaCarta>");
			System.out.println("			</carta>");
		}
		System.out.println("		</cartas>");
		System.out.println("	</futbolista>");
		System.out.println(" ");
		
		}
	}

}
