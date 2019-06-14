
public class THilo extends Thread {
	private static int tam=8;
	private static int[] vec = new int[tam];



	public void run()
	{
		for (int i=0;i<vec.length;i++)
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
