
public class RHilo implements Runnable{

	private Contador_Hilos cont;

	public RHilo(Contador_Hilos contador)
	{
		this.cont = contador;
	}

	@Override
	public void run()
	{
		for (int i=0; i<20000;i++)
		{
			this.cont.incrementaContador();
		}
	}

}
