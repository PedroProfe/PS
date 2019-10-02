package MatarProcesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder("TASKLIST");
		Process p;
		ProcessBuilder pbEliminarProceso;
		//@SuppressWarnings("unused")
		Process pbKill;
		Scanner respuesta = new Scanner(System.in);
	
		try
		{
			p = pb.start();
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String linea = null;
			// Saltamos la primera linea
			
			linea  = br.readLine();
			System.out.println("hola");
			while((linea = br.readLine()) != null)
			{
				System.out.print(linea + " ¿Eliminar proceso? (s/n):");
				if(respuesta.nextLine().equals("s"))
				{
					// Recorto el PID del proceso
					String idProceso = linea.split(" ")[1];
					System.out.println("El id del proceso "+ idProceso);
					// Ejecutamos kill con el PID
					pbEliminarProceso = new ProcessBuilder("TASKKILL",idProceso);
					pbKill = pbEliminarProceso.start();
				}
			}
			respuesta.close();
		}
		catch(IOException e){
			System.out.println(" hubo un error " + e.getMessage());
		}

		
	}

}
