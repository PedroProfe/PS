public class RHilo implements Runnable{

	private int id;
	private static Object cerrojo1= new Object();
	private static Object cerrojo2= new Object();



	public RHilo(int id)
	{
		this.id= id;

	}

//esta solución probocaría un interbloqueo entre los hilos...lo ideal es no trabajar con muchos cerrojos...
	/*
	 * Cuando utilizamos synchronized los hilos se quedan a la cola esperando como si fuera programación secuencial
	 * pura y dura. Utilizar hilos para dejarlos esperando no es una buena estrategia. */
/*
	public void run()
	{
		if (this.id%2==0)
		{
			synchronized(cerrojo1)//Activo: h0 Cola: h1
			{
				mostrarPares();
			}
		}
		else
		{
			synchronized(cerrojo2)//Activo: h1 Cola: h1 h3 h0
			{
				mostrarImpares();
			}
		}
	}

	private void mostrarPares()
	{
		synchronized(cerrojo2)
		{
			System.out.println("Soy el hilo " + this.id + " y soy par");
		}

	}
	private void mostrarImpares()
	{
		synchronized(cerrojo1)
		{
			System.out.println("Soy el hilo " + this.id + " y soy impar");
		}
	}*/

	/*Estrategia para solucionar el interbloqueo es la estrategia del buffer*/

	private int cont_private =0; //privada y de cada uno de los hilos
	public static int cont=0; //variable compartida por todos los hilos

	@Override
	public void run()
	{
		for (int i=0;i<20000;i++)//todos los hilos ejecutarán este for a la vez
		{
			cont_private++; //todos los hilos terminarán con esta variable a 20000
		}
		synchronized(cerrojo1){ //al salir del for valdrán 20000 y se sumarán a lo que ya tenga cont...solución muy eficinete
			cont+=cont_private;
		}
	}

}