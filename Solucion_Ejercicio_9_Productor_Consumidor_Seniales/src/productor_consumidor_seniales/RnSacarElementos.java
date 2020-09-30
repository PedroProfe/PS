package productor_consumidor_seniales;
public class RnSacarElementos implements Runnable
{
	private Elementos elementos;
	public RnSacarElementos(Elementos elementos)
	{
		this.elementos = elementos;
	}
	@Override
	public void run()
	{
		while(true)
		{
			elementos.sacarElemento();
		}
	}
}
