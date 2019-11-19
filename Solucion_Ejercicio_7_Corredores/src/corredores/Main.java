package corredores;

public class Main
{

	public static final int NUM_CORREDORES = 8;
	public static void main(String[] args)
	{


		Lista lista = new Lista(NUM_CORREDORES);

		Thread[] thCorredores = new Thread[NUM_CORREDORES];
		
		// Creación de los hilos
		for (int i = 0; i < thCorredores.length; i++)
		{
			thCorredores[i] = new Thread(new RnCorredor(i + 1, lista));
		}
		// Ejecución de los hilos
		for (int i = 0; i < thCorredores.length; i++)
		{
			thCorredores[i].start();
		}

		// El hilo main espera a que acaben todos los hilos (corredores)
		for (int i = 0; i < thCorredores.length; i++)
		{
			try
			{
				thCorredores[i].join();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		// Al terminar todos los corredores, la lista de llegadas ya está completa
		System.out.println("Mostrando resultados:");
		int[] resultados = lista.getResultados();
		for (int i = 0; i < resultados.length; i++)
		{
			System.out.println("Posicion: " + (i + 1) + " corredor " + resultados[i]);
		}
	}
}