package seccion_critica;
import java.util.Random;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random r = new Random(System.nanoTime());
		
		//creamos un vector de 10 elementos y lo rellenamos con números aleatorios
		int  []v = new int[10];
		for (int i=0;i<v.length;i++)
		{			
			//para evitar el 
			v[i]=r.nextInt(10);		
		}
		
		for (int i=0;i<v.length;i++)
		{			
			//para evitar el 
			System.out.print(v[i] + " ");
		}
		System.out.println();
		
		AlmacenVector  av = new AlmacenVector(v);
		
		//en este caso lo hacemos muy sencillo pasando los índices en los que tiente que trabajar
		//cada hilo
		
		
		THilo h1 = new THilo(av, 0,  Math.round(av.getVector().length/2));
		THilo h2 = new THilo(av,  Math.round(av.getVector().length/2), av.getVector().length);

		

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
