package pongpong;

public class Main
{

	public static void main(String[] args)
	{
		EscribePingPong escribePingPong = new EscribePingPong();


		Thread thPing = new Thread(new RnEscribePing(escribePingPong));
		Thread thPong = new Thread(new RnEscribePong(escribePingPong));

		thPong.start();
		thPing.start();


		//el main muere mientras se ejecutan los otros hilos
		System.out.println("El main ha terminado ");


	}

}
