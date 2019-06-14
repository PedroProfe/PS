
public class THilo extends Thread {
	private static int cont = 0;
	
	
	public void run()
	{
		for (int i = 0; i<1000; i++)//cada uno de los hilos dará 1000 vueltas
		{
			cont++;
		}
	}
	
	public static int getCont()
	{
		return cont;
	}

}
