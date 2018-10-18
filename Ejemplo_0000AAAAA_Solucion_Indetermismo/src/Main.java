import java.util.Random;

public class Main {

	private static int[] v;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

				Random r = new Random(System.nanoTime());

				THilo h1 = new THilo(0, 4);
				THilo h2 = new THilo(4, 8);

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
				 * 10 y el segundo hilo lo multiplica por 10.
				 * Yo al hilo uno le he dicho que se encargue de todo el vector y no solo de una parte. Además ambos hilos estan
				 * accediendo al mismo elemento osea a la misma sección crítica, por tanto tenemos un problema de indeterminismo..
				 *
				 *Una solución sería que un hilo se ocupara de la mitad del vector y el otro hilo de la segunda mitad..
				 *por eso creamos en el hilo la variable ini y fin...ver solución Ejemplo_0000AAAAA_Solucion_Indetermismo
				 * 
				 * 
				 */
				for (int i=0;i<v.length;i++)
				{
					System.out.print(v[i]+ " ");
				}
				



			}
	}


