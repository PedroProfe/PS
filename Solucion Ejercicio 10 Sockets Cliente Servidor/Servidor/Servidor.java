import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Servidor {


	private static HashMap<String, DataOutputStream> hmUsuarios;

	public Servidor()
	{
		hmUsuarios = new HashMap<>();
	}

	public void arrancar()
	{
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(5555);
			System.out.println("Servidor funcionando y a la espera de conexión de algún cliente");
			while (true)
			{
				socket  = serverSocket.accept();				
				Thread cliente = new Thread(new RnCliente(socket));
				cliente.start();				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static synchronized HashMap<String, DataOutputStream> getHmUsuarios() {
		return hmUsuarios;
	}

	public static synchronized void setHmUsuarios(String nick, DataOutputStream conexionSalida) {

		Servidor.hmUsuarios.put(nick, conexionSalida);
	}

	public static synchronized void envioNuevoNickaTodos(String nicknuevo)
	{
		try 
		{
			for (Entry<String, DataOutputStream> entry : hmUsuarios.entrySet())
			{
				DataOutputStream mensajeSalida = (DataOutputStream) entry.getValue();				
				mensajeSalida.writeUTF("Un nuevo usuario se ha conectado: " + nicknuevo);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static synchronized void borrarUsuario(String nickCliente)
	{
		try{
			if (hmUsuarios.containsKey(nickCliente))
			{
				System.out.println("el usuario " + nickCliente + " se va a borrar ");
				DataOutputStream mensajeSalida = (DataOutputStream) hmUsuarios.get(nickCliente);
				mensajeSalida.writeUTF("parar");
				hmUsuarios.remove(nickCliente);
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static synchronized void mensajeatodos(String mensaje, String nickCliente)
	{
		try 
		{
			
			for (Entry<String, DataOutputStream> entry : hmUsuarios.entrySet())
				{
					DataOutputStream mensajeSalida = (DataOutputStream) entry.getValue();
					//hay que controlar que enviamos a todos, excepto al que envió el mensaje
					mensajeSalida.writeUTF("El usuario " + nickCliente + " dice "+ mensaje);				
				}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		/*
		Iterator<String> iterator = hmUsuarios.keySet().iterator();
		String nombre;
		while (iterator.hasNext())
		{
			//Obtenemos la clave del índice del hash y la guardamos en nombre
			nombre = iterator.next();
			try {
				//vamos al hash donde esté ese nombre y escribimos en su cadena de conexión
				hmUsuarios.get(nombre).writeUTF(nick);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/

	}

}
