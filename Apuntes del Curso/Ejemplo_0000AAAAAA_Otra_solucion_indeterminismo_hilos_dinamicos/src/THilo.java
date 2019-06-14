
public class THilo extends Thread {
	private static int tam=15;
	private static int[][] mat = new int[tam][tam];

	//inicio y fin no son estáticas y serán independientes para cada hilo
	private int inicio,fin;

	public THilo(int ini, int fin)
	{
		this.inicio=ini;
		this.fin=fin;
	}

	public void run()
	{
		for (int i=this.inicio;i<this.fin;i++)
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

	public static int getTam() {
		return tam;
	}

	public static void setTam(int tam) {
		THilo.tam = tam;
	}

}

