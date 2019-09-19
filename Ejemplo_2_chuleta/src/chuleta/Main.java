package chuleta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Properties;

public class Main {

	public static void main(String[] args) throws IOException {
		
		long tiempoActual = System.currentTimeMillis();

		Runtime runtime = Runtime.getRuntime();
		
		int numCores = runtime.availableProcessors();
		
		long memoriaTotal = runtime.totalMemory();
		long memoriaMaximaDisponible = runtime.maxMemory();
		
		//---------------propiedades del sistema----------------------------
		
		Properties properties = System.getProperties();
		String clave;
		Integer lineas=0;
		Iterator<Object> iterator = properties.keySet().iterator();
		while(iterator.hasNext())
		{
			clave = (String)iterator.next();
			System.out.println(lineas.toString() + ": " + clave + ": " + properties.getProperty(clave));
			lineas++;
		}
		
		System.out.println("Número de cores " + numCores + ", memoria Total "+ 
		memoriaTotal + ", memoria Máxima disponible " + memoriaMaximaDisponible);
		
		//----------------Lanzamiento de Procesos con ProcessBuilder------------
		
		ProcessBuilder pb = new ProcessBuilder();
		pb.command("cmd.exe", "/c", "ipconfig");
		Process p = pb.start();
		
		//Lectura de la salida de la consola desde el programa
		InputStream is = p.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		String linea = br.readLine();
		while (linea != null)
		{
			 System.out.println("salida del ipconfig " + linea);
		     linea = br.readLine();
		}
		

	}

}
