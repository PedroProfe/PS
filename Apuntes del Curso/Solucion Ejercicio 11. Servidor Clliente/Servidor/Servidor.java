package ServidorV2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Map.Entry;

public class Servidor {
	
	private HashMap<String, DataOutputStream> hmUsuarios;
	private TreeSet<Integer> ts;
	
	
	public Servidor()
	{
		this.hmUsuarios = new HashMap<>();
		this.ts = new TreeSet<>();
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

	
	private class RnCliente implements Runnable
	{		
		Socket socket=null;

		private DataOutputStream salida;
		private DataInputStream entrada;

		public RnCliente(Socket socket)
		{
			this.socket = socket;
		}

		/*este run atiende a un cliente, por tanto en el while del run()
		 * se quedará escuchando las peticiones de ése cliente.*/
		@Override
		public void run() {
			String nickCliente = null;
			String mensaje = null;

			try {

				/*las instancias de los input y outputstream deben ser opuestas en el cliente.
				  es decir si instanciamos primero entrada (InputStream) debemos instanciar primero en el cliente
				  salida, es decir el dataoutputstream, si no lo hacemos así fallará.*/
				entrada = new DataInputStream(this.socket.getInputStream());
				salida = new DataOutputStream(this.socket.getOutputStream());

					nickCliente = entrada.readUTF();
					System.out.println("El nick del cliente es " + nickCliente);
					setHmUsuarios(nickCliente,salida);
					envioNuevoNickaTodos(nickCliente);
					//ahora enviamos a todos los clientes la lista de nicks del chat

					boolean seguir = true;
					while (seguir)
					{
						//este entrada.readUTF hace que el while se pare hasta que el cliente que ejecuta este
						//hilo hable.
						mensaje = entrada.readUTF();
						extraerNumeros(mensaje);
						//este println es para el servidor, y el nickCliente es el del cliente que ejecuta este 
						//hilo
						System.out.println("El cliente " + nickCliente + " dice " + mensaje);
						if (mensaje.equalsIgnoreCase("parar"))
						{
							borrarUsuario(nickCliente);
							String cadenaEnviar = "El usuario "+nickCliente+" ha dejado el chat";						
							mensajeatodos(cadenaEnviar, nickCliente);
							seguir = false;
						}
						else
						{
							mensajeatodos(mensaje, nickCliente);				
						}
						if (cincoNumerosLeidos())
						{
							System.out.println("se han leido 5 numeros " );
							mensajeatodosNumerosOrdenados();
						}
						//tiene que llegar a todos
					}

				//salida.writeUTF("Hola cliente soy el servidor y estos son los nick que hay conectados");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			try{
				if(entrada != null) entrada.close();
				if(salida != null) entrada.close();
				if(socket != null) entrada.close();

			}catch(IOException e)
			{
				
			}
		}

		private synchronized void mensajeatodosNumerosOrdenados()
		{				
			try 
			{
				String numerosOrdenados = obtenerNumerosOrdenados();
				for (Entry<String, DataOutputStream> entry : hmUsuarios.entrySet())
					{
						DataOutputStream mensajeSalida = (DataOutputStream) entry.getValue();						
						mensajeSalida.writeUTF("Ya se han leído 5 digitos distintos de uno o varios clientes y son los siguientes ordenados: " + numerosOrdenados);										
					}		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		private synchronized String obtenerNumerosOrdenados() {
			
			String cadenaNumeros="";			
			
					Iterator<Integer> itr = ts.iterator();
					while (itr.hasNext()){
						Integer n = itr.next();						
						cadenaNumeros = cadenaNumeros + n + " ";						
						}
					
			return cadenaNumeros;
		}

		private synchronized boolean cincoNumerosLeidos() {
			
			if (ts.size()==5)
			{				
				return true;
			}
			return false;			
		}

		private synchronized void extraerNumeros(String mensaje) {
		
			for (char ch: mensaje.toCharArray()) {
				
				if (Character.isDigit(ch))
				{
					int numero = Character.getNumericValue(ch);
					if (ts.size()<5)
					{
						ts.add(numero);
					}
					//System.out.println("Tamaño del treeset es " + ts.size());
				}
				
			}
		}
		
	}
	
	
	public synchronized HashMap<String, DataOutputStream> getHmUsuarios() {
		return hmUsuarios;
	}

	public synchronized void setHmUsuarios(String nick, DataOutputStream conexionSalida) {

		hmUsuarios.put(nick, conexionSalida);
	}

	public synchronized void envioNuevoNickaTodos(String nicknuevo)
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
	
	public synchronized void borrarUsuario(String nickCliente)
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
	
	public synchronized void mensajeatodos(String mensaje, String nickCliente)
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
			
	}

}
