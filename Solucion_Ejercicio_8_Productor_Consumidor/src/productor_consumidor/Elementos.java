package productor_consumidor;

public class Elementos
{
	private int[] elementos;
	private int cont;
	public Elementos(int num)
	{
		elementos = new int[num];
		cont = 0;
	}
	public synchronized boolean ponerElemento(int elem)
	{
		if(cont == elementos.length)
		{
			System.out.println("Pila llena.");
			return false;
		}

		if(elem < 0)
		{
			System.out.println("No se admiten negativos.");
			return false;
		}

		for (int i = 0; i < cont; i++)
		{
			if(elem == elementos[i])
			{
				System.out.println("Ya existe el " + elem);
				return false;
			}
		}

		elementos[cont] = elem;
		cont++;

		System.out.println("Se ha introducido el numero " + elem);
		return true;
	}


	public synchronized int sacarElemento()
	{
		if(cont == 0)
		{
			System.out.println("Pila vacia.");
			return -1;
		}

		cont--;
		System.out.println("Se ha extraido el numero " + elementos[cont]);
		return elementos[cont];
	}
}
