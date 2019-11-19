package primos_ordenados;

public class RnBuscaPrimos implements Runnable
{


	private int _inicio;
	private int _fin;
	private AlmacenOrdenadoSincronizado _almacen;
	public RnBuscaPrimos(int inicio, int fin, AlmacenOrdenadoSincronizado almacen)
	{
		_inicio = inicio;
		_fin = fin;
		_almacen = almacen;
	}
	@Override
	public void run()
	{
		for(int num = _inicio; num < _fin; num++)
		{
			if(esPrimo(num))
			{
				_almacen.add(num);
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
