package primos;

public class RnBuscaPrimos implements Runnable
{


	private int _inicio;
	private int _fin;
	public RnBuscaPrimos(int inicio, int fin)
	{
		_inicio = inicio;
		_fin = fin;
	}
	@Override
	public void run()
	{
		for(int num = _inicio; num < _fin; num++)
		{
			if(esPrimo(num))
			{
				System.out.println(num);
			}
		}
	}

	private boolean esPrimo(int num)
	{
		for(int div = 2; div <= num / 2; div++)
		{
			if(num % div == 0)
			{
				return false;
			}
		}

		return true;
	}

}
