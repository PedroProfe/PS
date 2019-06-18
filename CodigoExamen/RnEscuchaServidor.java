package Cliente;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class RnEscuchaServidor implements Runnable{

	DataInputStream entrada = null;
	DataOutputStream salida = null;
	private Socket socket = null;



	
	public RnEscuchaServidor(DataInputStream entrada,Socket socket,DataOutputStream salida)
	{
		this.entrada = entrada;
		this.socket=socket;
		this.salida=salida;
	}


	@Override
	public void run()
	{		
		String mensajeServidor=null;
		try 
		{
			Scanner lectura = new Scanner(System.in);
			boolean seguir = true;
		
			while (seguir)
			{												
				mensajeServidor = entrada.readUTF();
				System.out.println(mensajeServidor);
				
				if (mensajeServidor.contains("Intentos agotados.") || mensajeServidor.equals("Acertado"))
				{					
					seguir=false;					
				}	
			}
			
			desconectar(salida, entrada, socket);
		} catch (IOException e) {
				
			e.printStackTrace();
		}
		
		try{
			if(entrada != null) entrada.close();		
			if(socket != null) socket.close();
			if(salida != null) salida.close();

		}catch(IOException e)
		{			
		}
	}
	
	private static void desconectar(DataOutputStream salida, DataInputStream entrada, Socket socket) {
		
		try{
			
			String mensajeFinalServidor="";
			mensajeFinalServidor = entrada.readUTF();
			MainCliente.pararBucleMain();
			System.out.println(mensajeFinalServidor);		
			
			System.out.println("Desconectado");
			
			
			if(entrada != null) entrada.close();
			if(salida != null) entrada.close();
			if(socket != null) entrada.close();

		}catch(IOException e)
		{
			
		}
	}
	
	
}

