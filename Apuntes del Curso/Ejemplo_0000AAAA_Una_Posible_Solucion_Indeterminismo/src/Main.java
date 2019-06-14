import java.util.Random;

public class Main {

	private static int[] v;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random r = new Random(System.nanoTime());

		THilo h1 = new THilo();
		THilo h2 = new THilo();

		v=h1.getVec();

		for (int i=0;i<v.length;i++)
		{
			v[i]=r.nextInt(10);
		}

		h1.start();
		h2.start();

		try{
			h1.join();
			h2.join();
		}catch (Exception ex){}

		/*si lo ejecutamos tal cual esta, la salida sería muiltiplicada por 100, porque el primer hilo lo multiplica por
		 * 10 y el segundo hilo lo multiplica por 10
		 * 
		 * 
		 */
		for (int i=0;i<v.length;i++)
		{
			System.out.print(v[i]+ " ");
		}
		



	}

}
