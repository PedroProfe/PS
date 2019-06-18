package Cliente;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class MainCliente {

	static boolean seguirbuclehiloprincipal;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataOutputStream salida = null;
		DataInputStream entrada = null;
		Socket socket = null;
		Boolean desconectado= false;

	
		try {

			socket = new Socket("127.0.0.1",5555);
		
			salida = new DataOutputStream(socket.getOutputStream());
			entrada = new DataInputStream(socket.getInputStream());

			//lanzo el hilo de escucha
			RnEscuchaServidor rnescuchaServidor = new RnEscuchaServidor(entrada,socket,salida);
			Thread hiloescuchaServidor = new Thread(rnescuchaServidor);
			hiloescuchaServidor.start();		
			
			/*primero enviamos al servidor el nick para que todos nos conozcan*/
			System.out.println("Intruduzca su nick");
			Scanner lectura = new Scanner(System.in);
			String nick = lectura.nextLine();
			System.out.println("Conectado al servidor...");
			salida.writeUTF(nick);
			System.out.println("El Servidor ha generado un número aleatorio entre 1 y 10 exclusivo para usted, tiene 2 intentos para acertar");
			String mensajeServidor="";
			
			seguirbuclehiloprincipal=true;
			while (seguirbuclehiloprincipal)
			{				
				System.out.println("Introduce numero: ");
				String numero = lectura.nextLine();				
				salida.writeUTF(numero);
			}
			
			desconectar(salida, entrada, socket);
			

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void desconectar(DataOutputStream salida, DataInputStream entrada, Socket socket) {
				
		try{
			
			String mensajeFinalServidor="";
			mensajeFinalServidor = entrada.readUTF();
			System.out.println(mensajeFinalServidor);		
			
			System.out.println("Desconectado");
			
			
			if(entrada != null) entrada.close();
			if(salida != null) entrada.close();
			if(socket != null) entrada.close();

		}catch(IOException e)
		{
			
		}
	}
	
	public static void pararBucleMain()
	{
		seguirbuclehiloprincipal=false;
	}

}
