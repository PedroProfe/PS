package productor_consumidor_seniales;

public class Main
{

	public static void main(String[] args)
	{
		Elementos elementos = new Elementos(8);

		new Thread(new RnPonerElementos(elementos)).start();
		
		new Thread(new RnSacarElementos(elementos)).start();

	}

}
