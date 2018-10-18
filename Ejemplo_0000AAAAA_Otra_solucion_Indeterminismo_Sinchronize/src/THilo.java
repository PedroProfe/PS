
public class THilo extends Thread {
	private static int tam=4;
	private static int[][] mat = new int[tam][tam];

	private int inicio,fin;
	
	public THilo(int ini, int fin)
	{
		this.inicio=ini;
		this.fin=fin;
	}

	public void run()
	{
		for (int i=0;i<tam;i++)
		{
			for (int j=0;j<tam;j++)
			{
				mat[i][j] *=10;
			}
		
		}
	}

	public static int[][] getVec() {
		return mat;
	}

	public static void setVec(int[][] vec) {
		THilo.mat = vec;
	}

}
