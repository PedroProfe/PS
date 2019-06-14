package servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Número de puerto: ");
		int numPuerto = sc.nextInt();
		sc.close();
		ServerSocket serverSocket = null;
		Socket socket = null;
		DataInputStream entrada = null;
		try
		{
			serverSocket = new ServerSocket(numPuerto);
			System.out.println("Escuchando en el puerto " + numPuerto + "...");
			socket = serverSocket.accept();
			System.out.println("Entró un cliente.");
			entrada = new DataInputStream(socket.getInputStream());
			while(true)
			{
				System.out.println("Cliente dice: " + entrada.readUTF());
			}

		}
		catch (IOException e)
		{
			System.out.println("Error de comunicación.");
		}

		try
		{
			if(entrada != null) entrada.close();
			if(socket != null) socket.close();
			if(serverSocket != null) serverSocket.close();
		}
		catch(IOException e){}
	}

}
