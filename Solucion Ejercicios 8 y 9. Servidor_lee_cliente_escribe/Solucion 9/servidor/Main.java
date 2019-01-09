package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int contClientes = 0;
		System.out.print("Número de puerto por el que el servidor escucha: ");
		int numPuerto = sc.nextInt();
		sc.close();
		ServerSocket serverSocket = null;
		Socket socket = null;
		try
		{
			serverSocket = new ServerSocket(numPuerto);
			while(true)
			{
				socket = serverSocket.accept();
				new Thread(new RnCliente(socket, contClientes++)).start();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Error de conexión.");
		}
		try
		{
			if(socket != null)socket.close();
			if(serverSocket != null) serverSocket.close();
		} catch (IOException e)	{}
	}
}
