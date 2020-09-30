package primos_ordenados;

import java.util.Iterator;

public class Main
{
	private final static int NUM = 1000000;

	public static void main(String[] args)
	{
		AlmacenOrdenadoSincronizado almacen = new AlmacenOrdenadoSincronizado();

		Runtime runtime = Runtime.getRuntime();
		System.out.println("Número de cores: " + runtime.availableProcessors());

		int numCores = runtime.availableProcessors();

		int rango = Math.round(NUM / (float)numCores);

		int inicioRango = 0;
		int finRango = rango;

		Thread[] threads = new Thread[numCores];

		// Lanzamos tantos hilos como cores tenga el sistema
		for (int i = 0; i < numCores; i++)
		{
			threads[i] = new Thread(new RnBuscaPrimos(inicioRango, finRango, almacen));
			threads[i].start();
			inicioRango += rango;
			finRango += rango;
			if(i == numCores - 2)
			{
				finRango = NUM + 1;
			}
		}
		// Esperar a que terminen los hilos

		for (int i = 0; i < threads.length; i++)
		{
			try
			{
				threads[i].join();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}



		// Mostrar el contenido del almacen
		Iterator<Integer> iterator = almacen.getIterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}

	}
}
