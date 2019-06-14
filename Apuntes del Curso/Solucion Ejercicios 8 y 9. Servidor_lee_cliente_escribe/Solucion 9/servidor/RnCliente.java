package servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class RnCliente implements Runnable
{

	private int numCliente;
	private Socket socket;

	public RnCliente(Socket socket, int numCliente)
	{
		this.numCliente = numCliente;
		this.socket = socket;
	}
	@Override
	public void run()
	{
		DataInputStream entrada = null;
		try
		{
			entrada = new DataInputStream(socket.getInputStream());
			System.out.println("Ha entrado el cliente " + numCliente + ".");
			while(true)
			{
				System.out.println("Cliente " + numCliente + ": " + entrada.readUTF());
			}
		}
		catch (IOException e)
		{
			System.out.println("Desconectado cliente " + numCliente + ".");
		}
		try
		{
			if(entrada != null) entrada.close();
			if(socket != null) socket.close();
		}
		catch (IOException e) {}

	}

}
