package unodostres;
import java.io.*;

public class EscribeUnoDosTres
{

	private final int TURNO_UNO = 1;
	private final int TURNO_DOS = 2;
	private final int TURNO_TRES = 3;

	private int turnoActual = TURNO_UNO;
	//-------------------------------------para la segunda solución---------------------------------
	private Object obj = new Object();
	private int valorActual = 3;
	private int cont=0;

	BufferedWriter bw = null;
    FileWriter fw = null;
    File fichero = new File("salidaUnoDosTres.txt");

    public EscribeUnoDosTres()
    {
    	try{
	    	 if (!fichero.exists()) {
	    		 fichero.createNewFile();
	         }

	    	 fw = new FileWriter(fichero.getAbsoluteFile(), true);
	         bw = new BufferedWriter(fw);
	         bw.write("Comienzo del ejercicio");
	         bw.write("\n");

    	}catch(IOException ex)
    	{
    		ex.printStackTrace();
    	}
    }



	/*----------------------------------primera solución-------------------------------------------------------------

	public synchronized void escribeUno()
	{
		System.out.println("Intento de escribir el UNO");
		if(turnoActual == TURNO_UNO)
		{
			System.out.println("Uno");
			turnoActual = TURNO_DOS;
		}
		notify();
		try	{wait();} catch (InterruptedException e){}

	}
	public synchronized void escribeDos()
	{
		System.out.println("Intento de escribir el DOS");
		if(turnoActual == TURNO_DOS)
		{
			System.out.println("Dos");
			turnoActual = TURNO_TRES;
		}
		notify();
		try	{wait();} catch (InterruptedException e){}

	}
	public synchronized void escribeTres()
	{
		System.out.println("Intento de escribir el TRES");
		if(turnoActual == TURNO_TRES)
		{
			System.out.println("Tres");
			turnoActual = TURNO_UNO;
		}
		notify();
		try	{wait();} catch (InterruptedException e){}
	}
	*/
	//------------------------------------------------segunda solución-----------------------------------------------------


	public void escribeUno()
	{
		//ESTA SOLUCIÓN NO ECHA EL HILO A DORMIR POR TANTO ES MUCHO MÁS INEFICIENTE, YA QUE EL BUCLE DE LLAMADA SIGUE FUNCIONANDO INFINITAMENTE

		synchronized (obj)
		{
			if (cont!=200)
			{
				if  (valorActual == 3)
				{

					System.out.println("Uno");
					try {
						bw.write(" Uno ");
						bw.write("\n");

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					valorActual = 1;
					cont++;
				}
			}

		}
	}

	public void escribeDos()
	{
		synchronized (obj)
		{
			if (cont!=200)
			{
				if  (valorActual == 1)
				{
					System.out.println("Dos");
					try {
						bw.write(" Dos ");
						bw.write("\n");

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					valorActual = 2;
				}
			}
		}
	}

	public void escribeTres()
	{
		synchronized (obj)
		{
			if (cont!=200){
				if  (valorActual == 2)
				{
					System.out.println("Tres");
					try {
						bw.write(" Tres ");
						bw.write("\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					valorActual = 3;
				}
			}
		}

		if (cont==200)
		{
			 try {
                 //Cierra instancias de FileWriter y BufferedWriter
				 System.out.println("cerrando el fichero desde escribeTres");
			     if (bw != null)
			         bw.close();
			     if (fw != null)
			         fw.close();

			     RnEscribeTres.setSeguir(false);
			 } catch (IOException ex) {
			     ex.printStackTrace();
			 }
		}
	}



}
