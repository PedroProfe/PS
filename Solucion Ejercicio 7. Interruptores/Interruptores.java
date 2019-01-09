package interruptores;

public class Interruptores
{
	private boolean[] interruptores;
	private boolean todosOn;


	public Interruptores(int num)
	{
		interruptores = new boolean[num];
	}

	public synchronized boolean pulsarInterruptor(String operario, int numInterruptor)
	{

		if(todosEncendidos())
		{
			return true;
		}


		interruptores[numInterruptor] = !interruptores[numInterruptor];
		System.out.println("El operario " + operario + " ha pulsado el interruptor " + numInterruptor);
		mostrarInterruptores();

		notify();

		todosOn = todosEncendidos();

		if(!todosOn)
		{
			try	{wait();} catch (InterruptedException e){}
		}

		return todosOn;
	}

	private void mostrarInterruptores()
	{
		for (int i = 0; i < interruptores.length; i++)
		{
			System.out.print((interruptores[i] ? "on" : "off") + "\t");
		}
		System.out.println();
	}


	private boolean todosEncendidos()
	{
		for (int i = 0; i < interruptores.length; i++)
		{
			if(!interruptores[i])
				return false;
		}
		return true;
	}

	public int getNumeroInterruptores()
	{
		return interruptores.length;
	}


}
