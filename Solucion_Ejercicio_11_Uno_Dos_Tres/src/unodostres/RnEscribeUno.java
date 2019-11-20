package unodostres;

public class RnEscribeUno implements Runnable
{

	private EscribeUnoDosTres escribeUnoDosTres;


	public RnEscribeUno(EscribeUnoDosTres escribeUnoDosTres)
	{
		this.escribeUnoDosTres = escribeUnoDosTres;
	}

	@Override
	public void run()
	{
		while(true)
		{
			escribeUnoDosTres.escribeUno();
		}

	}

}
