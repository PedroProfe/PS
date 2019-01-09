package interruptores;

import java.util.Random;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Número de interruptores: ");
		Interruptores interruptores = new Interruptores(Integer.parseInt(sc.nextLine()));

		System.out.print("Operario 1: ");
		String operario1 = sc.nextLine();
		System.out.print("Operario 2: ");
		String operario2 = sc.nextLine();

		sc.close();

		new Thread(new RnOperario(operario1, interruptores)).start();
		new Thread(new RnOperario(operario2, interruptores)).start();
	}

	private static class RnOperario implements Runnable
	{

		private String operario;
		private Interruptores interruptores;

		public RnOperario(String operario, Interruptores interruptores)
		{
			this.operario = operario;
			this.interruptores = interruptores;
		}


		@Override
		public void run()
		{
			Random random = new Random();
			while(!interruptores.pulsarInterruptor(operario, random.nextInt(interruptores.getNumeroInterruptores())));
		}

	}

}
