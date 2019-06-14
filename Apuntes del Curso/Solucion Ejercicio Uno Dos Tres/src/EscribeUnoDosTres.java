
public class EscribeUnoDosTres {
	private int turno=3;
	private Object obj = new Object();


	public void escribeUno()
	{
		synchronized(obj)
		{
			if (turno==3)
			{
				System.out.println("Uno");
				turno=1;
			}
			obj.notify();
			try {obj.wait();}catch(InterruptedException e){}
		}
	}
	public void escribeDos()
	{
		synchronized(obj)
		{
			if (turno==1){
				System.out.println("Dos");
				turno=2;
			}
			obj.notify();
			try {obj.wait();}catch(InterruptedException e){}
		}
	}

	public void escribeTres()
	{
		synchronized(obj)
		{
			if (turno==2)
			{
				System.out.println("Tres");
				turno=3;
			}

			obj.notify();
			try {obj.wait();}catch(InterruptedException e){}
		}
	}

}
