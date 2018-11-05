
public class RnCorredor implements Runnable
{

	private int numCorredor;
	private Lista lista;
	public RnCorredor(int numCorredor, Lista lista)
	{
		this.numCorredor = numCorredor;
		this.lista = lista;
	}
	@Override
	public void run()
	{
		for (int i = 1; i <= 10000000; i++);
		lista.apuntarCorredor(numCorredor);
	}

}
