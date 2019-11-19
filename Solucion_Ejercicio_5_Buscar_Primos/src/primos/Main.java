package primos;

public class Main
{

	private final static int NUM = 1000000;

	public static void main(String[] args)
	{
		Runtime runtime = Runtime.getRuntime();
		System.out.println("NÃºmero de cores: " + runtime.availableProcessors());

		int numCores = runtime.availableProcessors();

		int rango = Math.round(NUM / (float)numCores);
        //NUM ES UN MILLÓN 
		System.out.println(rango); //en mi caso son 250000, porque tengo 4 cores
		int inicioRango = 0;
		int finRango = rango;

		// Lanzamos tantos hilos como cores tenga el sistema 999983
		for (int i = 0; i < numCores; i++)
		{
			new Thread(new RnBuscaPrimos(inicioRango, finRango)).start();
			inicioRango += rango;
			finRango += rango;
			if(i == numCores - 2) //no entiendo muy bien esa línea
			{
				finRango = NUM + 1;
			}
		}
	}
}
