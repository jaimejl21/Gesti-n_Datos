package GestionDatos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class partidos {
	public static void generarIdPartidos(String [] partidos) {
		for(int i=0;i<=99;i++) {
			if(i<9) {
				partidos[i]="partido-00"+(i+1);
			}
			else if(i>=9&&i<=98) {
				partidos[i]="partido-0"+(i+1);
			}
			else {
				partidos[i]="partido-"+(i+1);
			}
		}
	}
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
	public static void generarEquipos(List <equipo> equipos) throws IOException{
		FileReader fr = new FileReader("C:\\Users\\raul2\\Desktop\\Segundo cuatri\\Entornos\\Eclipse\\algoritmos\\equiposJ.txt");
		BufferedReader bf = new BufferedReader(fr);
		String linea;
		int aux=0;
		int idEquipo=0;
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
				 aux2.id=idEquipo;
				 idEquipo++;
				 equipos.add(aux2);
				 
				 
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
	public static void generarSalas(String [] salas) {
		
		for(int i=0;i<=199;i++) {
			salas[i]="s"+(i+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String [] idPartidos= new String[100];
		String [] jugadores=new String [100];
		String [] futbolistas=new String[100];
		String [] salas=new String [200]; 
		//String [] equipos=new String [100];
		List<equipo> equipos = new ArrayList<equipo>();
		generarIdPartidos(idPartidos);
		generarUsuarios(jugadores);
		generarEquipos(equipos);
		generarFutbolistas(futbolistas);
		generarSalas(salas);
		List<String> jugadoresDelPartido = new ArrayList<String>();
		List<String> equiposDelPartido = new ArrayList<String>();
		
		
		List<String> jugadoresParaJugadas = new ArrayList<String>();
		int auxJugJugadas=0;
		List<equipo> equiposParaJugadas = new ArrayList<equipo>();
		int auxEquiJugadas=0;
		String [] tipoTajeta= {"roja","amarilla"};
		
		int minutos=0;
		int segundos=0;
		
		for(int i=0;i<=99;i++) {
		System.out.println("<partido idPartido='"+idPartidos[i]+"'>");
		System.out.println("	<jugadores>");		
			for(int j=0;j<=1;j++) {
				String jugador=jugadores[(int)Math.floor(Math.random()*(99-0+1)+0)];
				if(!jugadoresDelPartido.contains(jugador)) {
					jugadoresDelPartido.add(jugador);
					jugadoresParaJugadas.add(jugador);
					System.out.println("		<jugador>"+jugador.replaceAll(" ","")+"</jugador>");
				}else {
					j--;
				}
			}
			System.out.println("	</jugadores>");
			System.out.println("	<equipos>");
			for(int j=0;j<=1;j++) {
				equipo aux=equipos.get((int)Math.floor(Math.random()*(8-0+1)+0));
				String equipo=aux.nombre;
				equiposDelPartido.add(equipo);
				equiposParaJugadas.add(aux);
				System.out.println("		<equipo>"+equipo+"</equipo>");
			}
			System.out.println("	</equipos>");
			int ganador=(int)Math.floor(Math.random()*(1-0+1)+0);
			System.out.println("	<equipoGanador>"+equiposDelPartido.get(ganador)+"</equipoGanador>");
			System.out.println("	<jugadorGanador>"+jugadoresDelPartido.get(ganador).replaceAll(" ","")
					+"</jugadorGanador>");
			System.out.println("	<sala>"+salas[(int)Math.floor(Math.random()*(199-0+1)+0)]+"</sala>");
			jugadoresDelPartido.clear();
			equiposDelPartido.clear();
			System.out.println("</partido>");
			System.out.println(" ");
		}
		System.out.println("PONER PUNTO DE RUPUTURA AQUI PARA PODER COPIAR TODOS LOS ELEMENTOS");
		for(int i=0;i<=99;i++) {
			System.out.println("<partido id='"+idPartidos[i]+"'>");
			System.out.println("	<jugadores>");
			System.out.println("		<jugador>"+jugadoresParaJugadas.get(auxJugJugadas++).replaceAll(" ","")
					+"</jugador>");
			System.out.println("		<jugador>"+jugadoresParaJugadas.get(auxJugJugadas++).replaceAll(" ","")
					+"</jugador>");
			System.out.println("	</jugadores>");
			System.out.println("	<equipos>");
			System.out.println("		<equipo>"+equiposParaJugadas.get(auxEquiJugadas++).nombre+"</equipo>");
			System.out.println("		<equipo>"+equiposParaJugadas.get(auxEquiJugadas++).nombre+"</equipo>");
			System.out.println("	</equipos>");
			System.out.println("	<jugadas>");
			for(int j=0;j<=3;j++) {
				int evento=(int)Math.floor(Math.random()*(3-0+1)+0);
				minutos=minutos+(int)Math.floor(Math.random()*(15-1+1)+1);
				segundos=(int)Math.floor(Math.random()*(59-10+1)+10);
				equipo equipoDelEvento=equiposParaJugadas.get(auxEquiJugadas-(int)Math.floor(Math.random()*
						(2-1+1)+1));
				String futbolistaEvento=futbolistas[equipoDelEvento.id*11+(int)Math.floor(Math.random()*
						(10-0+1)+0)];
						
				if(evento==0) {
			System.out.println("		<gol>");	
			System.out.println("			<minuto>"+minutos+":"+segundos+"</minuto>");
			System.out.println("			<equipo>"+equipoDelEvento.nombre+"</equipo>");
			System.out.println("			<futbolista>"+futbolistaEvento+"</futbolista>");
			System.out.println("		</gol>");
				}
				else if(evento==1) {
					System.out.println("		<tarjeta>");	
					System.out.println("			<minuto>"+minutos+":"+segundos+"</minuto>");
					System.out.println("			<color>"+tipoTajeta[(int)Math.floor(Math.random()*(1-0+1)+0)]+"</color>");
					System.out.println("			<futbolista>"+futbolistaEvento+"</futbolista>");
					System.out.println("		</tarjeta>");		
				}
				else if(evento==2) {
				System.out.println("		<cambio>");	
				System.out.println("			<minuto>"+minutos+":"+segundos+"</minuto>");
				System.out.println("			<equipo>"+equipoDelEvento.nombre+"</equipo>");
				if((int)Math.floor(Math.random()*(5-1+1)+1)==5) {
				System.out.println("			<lesion>"+"Si"+"</lesion>");
				}
				System.out.println("		</cambio>");
				}
			}
			minutos=0;
			segundos=0;
			System.out.println("	</jugadas>");
			
			
			System.out.println("</partido>");
		}
	
	}
	
	

}
