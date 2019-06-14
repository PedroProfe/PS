
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
			notify();//SI NO PONGO ESTE NOTIFY CORRO EL RIESGO DE CAER EN BLOQUEO MUTUO
			try	{wait();} catch (InterruptedException e){}
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

		System.out.println("Se ha introducido el número " + elem);
		return true;
	}


	public synchronized int sacarElemento()
	{
		if(cont == 0)
		{
			System.out.println("Pila vacía.");
			notify();
			try	{wait();} catch (InterruptedException e){}
			return -1;
		}

		cont--;
		System.out.println("Se ha extraído el número " + elementos[cont]);
		return elementos[cont];
	}
}
