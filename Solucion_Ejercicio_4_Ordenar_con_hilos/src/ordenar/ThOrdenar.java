package ordenar;

import ordenar.Ordenar;

public class ThOrdenar extends Thread
{
	private int[] _numeros;


	public ThOrdenar (int[] numeros)
	{
		_numeros = numeros;
	}

	@Override
	public void run()
	{
		Ordenar.ordenar(_numeros);
	}

}
