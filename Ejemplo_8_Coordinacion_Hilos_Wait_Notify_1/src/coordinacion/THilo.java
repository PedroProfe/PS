package coordinacion;

public class THilo extends Thread{

	private int numhilo;
	private AlmacenComunEscritura ace;
	
	public THilo(int numh, AlmacenComunEscritura ace)
	{
		this.numhilo=numh;
		this.ace = ace;
	}
	
	public void run()
	{
		ace.escribirHilo(this.numhilo);
	}
	
}
