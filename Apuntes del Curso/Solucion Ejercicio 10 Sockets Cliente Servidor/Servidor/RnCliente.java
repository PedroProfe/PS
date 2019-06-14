import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RnCliente implements Runnable {

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
				Servidor.setHmUsuarios(nickCliente,salida);
				Servidor.envioNuevoNickaTodos(nickCliente);
				//ahora enviamos a todos los clientes la lista de nicks del chat

				boolean seguir = true;
				while (seguir)
				{
					//este entrada.readUTF hace que el while se pare hasta que el cliente que ejecuta este
					//hilo hable.
					mensaje = entrada.readUTF();
					//este println es para el servidor, y el nickCliente es el del cliente que ejecuta este 
					//hilo
					System.out.println("El cliente " + nickCliente + " dice " + mensaje);
					if (mensaje.equalsIgnoreCase("parar"))
					{
						Servidor.borrarUsuario(nickCliente);
						String cadenaEnviar = "El usuario "+nickCliente+" ha dejado el chat";						
						Servidor.mensajeatodos(cadenaEnviar, nickCliente);
						seguir = false;
					}
					else
					{
						Servidor.mensajeatodos(mensaje, nickCliente);
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

}
