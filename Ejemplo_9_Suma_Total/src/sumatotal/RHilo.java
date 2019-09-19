package sumatotal;
public class RHilo implements Runnable{

	private int id;
	private static Object cerrojo= new Object();

	public RHilo(int id)
	{
		this.id= id;

	}


	private int cont_private =0; //privada y de cada uno de los hilos
	public static int cont=0; //variable compartida por todos los hilos

	@Override
	public void run()
	{
		for (int i=0;i<20000;i++)//todos los hilos ejecutarán este for a la vez
		{
			cont_private++; //todos los hilos terminarán con esta variable a 20000
		}
		synchronized(cerrojo){ //al salir del for valdrán 20000 y se sumarán a lo que ya tenga cont...solución muy eficinete
			cont+=cont_private;
		}
	}

}