
import java.util.Random;

public class Main {

	private static int[][] m;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

				Random r = new Random(System.nanoTime());
				double tiempoInicial, tiempoFinal;

				

				m=THilo.getVec();//esa matriz es compartida por h1 y h2

				for (int i=0;i<m.length;i++)
				{
					for (int j=0;j<m[0].length;j++)
					{
						m[i][j]=r.nextInt(10);
					}
				
				}

				tiempoInicial = System.nanoTime();
				THilo h1 = new THilo(0,2);
				THilo h2 = new THilo(2,4);
				h1.start();
				h2.start();

				try{
					h1.join();
					h2.join();
				}catch (Exception ex){}
				
				tiempoFinal = System.nanoTime()-tiempoInicial;//lo da en nanosegundos
				
				System.out.println("Ha tardado "+ (tiempoFinal/1000000)+ " milisegundos");//lo pasammos a milisegundos

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
				
				
				for (int i=0;i<m.length;i++)
				{
					for (int j=0;j<m[0].length;j++)
					{
						System.out.print(m[i][j]+ " ");
					}
					System.out.println("");				
				}



			}
	}

