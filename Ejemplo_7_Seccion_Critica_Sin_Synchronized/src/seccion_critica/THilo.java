package seccion_critica;

public class THilo extends Thread {
	AlmacenVector av;
	int min,max;
	
	public THilo(AlmacenVector almacenvector, int min, int max)
	{
		this.av=almacenvector;
		this.min=min;
		this.max=max;
	}


	public void run()
	{
		for (int i=min;i<max;i++)
		{
			this.av.getVector()[i]= this.av.getVector()[i]*10;
		}
	}

	
}
