package cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		String host;
		int numPuerto;
		Scanner sc = new Scanner(System.in);
		System.out.print("Servidor remoto: ");
		host = sc.nextLine();
		System.out.print("Número de puerto: ");
		numPuerto = Integer.parseInt(sc.nextLine());
		Socket socket = null;
		DataOutputStream salida = null;
		try
		{
			socket = new Socket(host, numPuerto);

			salida = new DataOutputStream(socket.getOutputStream());

			while(true)
			{
				System.out.print("Cadena a enviar: ");
				salida.writeUTF(sc.nextLine());
			}


		}
		catch(IOException e)
		{
			System.out.println("Error de comunicación.");
		}

		try
		{
			if(salida != null) salida.close();
			if(socket != null) socket.close();
			sc.close();

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}


	}

}
