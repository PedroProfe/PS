package unodostres;

public class Main
{

	public static void main(String[] args)
	{
		EscribeUnoDosTres escribeUnoDosTres = new EscribeUnoDosTres();
		Thread thUno = new Thread(new RnEscribeUno(escribeUnoDosTres));
		Thread thDos = new Thread(new RnEscribeDos(escribeUnoDosTres));
		Thread thTres = new Thread(new RnEscribeTres(escribeUnoDosTres));
		thTres.start();
		thDos.start();
		thUno.start();

	}

}
