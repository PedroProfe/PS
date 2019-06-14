package ladrones;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("Número de lingotes iniciales en la caja fuerte: ");

		CajaFuerte cajaFuerte = new CajaFuerte(sc.nextInt(),2);

		sc.close();

		Thread thLadron1 = new Thread(new RnLadron(1, cajaFuerte));
		Thread thLadron2 = new Thread(new RnLadron(2, cajaFuerte));

		thLadron2.start();
		thLadron1.start();

	}

}
