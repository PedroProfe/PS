package indeterminismo;

public class THilo extends Thread {

	AlmacenContador ac;
	
	public THilo(AlmacenContador a)
	{
		this.ac = a;
	}
	
	
	public void run()
	{
		for (int i = 0;i<100;i++)
			this.ac.incrementaContador();
	}
		

}
