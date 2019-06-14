import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RnEscuchaServidor implements Runnable{

	DataInputStream entrada = null;
	DataOutputStream salida = null;
	private Socket socket = null;
	private boolean parar=false;


	//paso el socket y salida al constructor para evitar el error de salida del chat y poder cerrar
	//en condiciones sin que haya error
	public RnEscuchaServidor(DataInputStream entrada,Socket socket,DataOutputStream salida)
	{
		this.entrada = entrada;
		this.socket=socket;
		this.salida=salida;
	}


	@Override
	public void run()
	{		
		try 
		{
			String servidorDice="";
			while (!parar)
			{	
				//está parado esperando el mensaje del servidor y si se corta la comunicación porque 
				//el cliente ha escrito parar hay que controlar esa excepción
				servidorDice = entrada.readUTF();
				System.out.println("El servidor dice " + servidorDice);			
			}
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
	
	public void dejardeEscucharServidor()
	{
		this.parar = true;
	}
	
}
