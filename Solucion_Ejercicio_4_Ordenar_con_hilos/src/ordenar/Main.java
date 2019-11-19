package ordenar;

import java.util.Random;


public class Main
{

	public static void main(String[] args)
	{
		final int NUM = 100000;
		int[] numeros1 = new int[NUM];
		int[] numeros2 = new int[NUM];
		Random random = new Random();
		System.out.println("Rellenando arrays con aleatorios...");
		for (int i = 0; i < numeros1.length; i++)
		{
			numeros1[i] = random.nextInt(1000) + 1;
			numeros2[i] = random.nextInt(1000) + 1;
		}
		System.out.println("Arrays rellenos.");
		System.out.println("Ordenando...");

		ThOrdenar thOrdenar1 = new ThOrdenar(numeros1);
		ThOrdenar thOrdenar2 = new ThOrdenar(numeros2);


		long tiempoComienzo = System.currentTimeMillis();

		thOrdenar1.start();
		thOrdenar2.start();

		// Me pauso hasta que acabe el hilo thOrdenar1
		try
		{
			thOrdenar1.join();
			thOrdenar2.join();
		}
		catch (InterruptedException e){}


		long tiempoFinal = System.currentTimeMillis();

		System.out.println("Ha tardado " + (tiempoFinal - tiempoComienzo) + " milisegundos");

	}

}
