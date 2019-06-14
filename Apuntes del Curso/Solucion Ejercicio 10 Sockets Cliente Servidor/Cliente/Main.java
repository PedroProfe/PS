import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

	
	/*El cliente tendrá en funcionamiento dos hilos, el del main y el de escucha del servidor, uno 
	 * será para escribir y el otro para escuchar respectivamente*/
	public static void main(String[] args) {

		DataOutputStream salida = null;
		DataInputStream entrada = null;
		Socket socket = null;

		/*El try catch debe estar fuera del bucle while, para prevenir futuros problemas*/
		try {

			socket = new Socket("127.0.0.1",5555);
			/*La instanciación de estas dos variables debe ser opuesta en el servidor*/
			salida = new DataOutputStream(socket.getOutputStream());
			entrada = new DataInputStream(socket.getInputStream());

			//lanzo el hilo de escucha
			RnEscuchaServidor rnescuchaServidor = new RnEscuchaServidor(entrada,socket,salida);
			Thread hiloescuchaServidor = new Thread(rnescuchaServidor);
			hiloescuchaServidor.start();
			
			
			/*primero enviamos al servidor el nick para que todos nos conozcan*/
			Scanner lectura = new Scanner(System.in);
			System.out.println("Introduzca su nick");
			String nick = lectura.nextLine();
			salida.writeUTF(nick);			
			String parar="";
			while (!parar.equalsIgnoreCase("parar"))
			{				
				System.out.println("Introduzca su mensaje");
				String mensaje = lectura.nextLine();
				if (mensaje.equalsIgnoreCase("parar"))
				{
					rnescuchaServidor.dejardeEscucharServidor();
					parar="parar";
					salida.writeUTF("parar");					
				}
				else
				{
					salida.writeUTF(mensaje);	
				}				
			}
			lectura.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		



	}

}
