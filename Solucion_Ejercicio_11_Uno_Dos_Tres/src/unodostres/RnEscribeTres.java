package unodostres;

public class RnEscribeTres implements Runnable
{

	private EscribeUnoDosTres escribeUnoDosTres;
	private static boolean seguir=true;


	public static boolean isSeguir() {
		return seguir;
	}

	public static void setSeguir(boolean seguir) {
		RnEscribeTres.seguir = seguir;
	}

	public RnEscribeTres(EscribeUnoDosTres escribeUnoDosTres)
	{
		this.escribeUnoDosTres = escribeUnoDosTres;
	}

	@Override
	public void run()
	{
		while((true)&&(seguir))
		{
			escribeUnoDosTres.escribeTres();
		}

	}

}
