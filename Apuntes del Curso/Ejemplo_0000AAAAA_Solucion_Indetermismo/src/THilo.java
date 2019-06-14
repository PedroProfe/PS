
public class THilo extends Thread {
	private static int tam=8;
	private static int[] vec = new int[tam];
	
	private int inicio, fin;
	
	public THilo(int ini, int fin)
	{
		this.inicio=ini;
		this.fin=fin;
	}



	public void run()
	{
		for (int i=this.inicio;i<this.fin;i++)
		{
			vec[i] *=10;
		}
	}

	public static int[] getVec() {
		return vec;
	}

	public static void setVec(int[] vec) {
		THilo.vec = vec;
	}

}
