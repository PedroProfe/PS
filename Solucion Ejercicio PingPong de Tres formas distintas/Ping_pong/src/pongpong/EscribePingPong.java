package pongpong;

public class EscribePingPong
{
	private boolean pingMostrado = false;
	private Object obj = new Object();



	//-----------------------------------primera solución--------------------------------------------------

	//solo hay dos hilos, luego un notify libera al otro hilo..el primer notify no hace nada (el del ping)
	/*
	public synchronized void escribePing()
	{
		pingMostrado = true;
		System. out .println("ping");
		notify();
		try	{wait();} catch (InterruptedException e){}

	}
	public synchronized void escribePong()
	{
		if(pingMostrado)
		{
			System. out .println("pong");
			notify();
			try	{wait();} catch (InterruptedException e){}
		}
	}
	*/

	//-----------------------------------segunda solución--------------------------------------------------

	/*

	public void escribePing()
	{
		synchronized(obj)
		{
			pingMostrado = true;
			System. out .println("ping");

			obj.notify();
			try	{obj.wait();} catch (InterruptedException e){}
		}

	}
	public void escribePong()
	{
		synchronized (obj){
			if(pingMostrado)
			{
				System. out .println("pong");
				obj.notify();
				try	{obj.wait();} catch (InterruptedException e){}
			}
		}
	}
	*/

	//-----------------------------------tercera solución--------------------------------------------------

	public void escribePing()
	{
		synchronized(obj)
		{
			pingMostrado = true;
			System. out .println("ping");

			obj.notify();
			try	{obj.wait();} catch (InterruptedException e){}//una vez pinta se echa a dormir para hasta que se pinta pong
		}

	}
	public void escribePong()
	{
		synchronized (obj){
			if (!pingMostrado)
				try	{obj.wait();} catch (InterruptedException e){}

				System. out .println("pong");
				pingMostrado=false;//esta sentencia nos la podemos ahorrar
				obj.notify();

		}
	}
}







