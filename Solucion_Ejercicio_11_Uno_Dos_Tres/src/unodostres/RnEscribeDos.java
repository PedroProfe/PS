package unodostres;

public class RnEscribeDos implements Runnable
{

	private EscribeUnoDosTres escribeUnoDosTres;


	public RnEscribeDos(EscribeUnoDosTres escribeUnoDosTres)
	{
		this.escribeUnoDosTres = escribeUnoDosTres;
	}

	@Override
	public void run()
	{
		while(true)
		{
			escribeUnoDosTres.escribeDos();
		}

	}

}
