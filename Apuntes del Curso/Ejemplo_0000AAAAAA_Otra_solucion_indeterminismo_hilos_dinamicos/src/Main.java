
import java.util.Random;

public class Main {

	private static int[][] m;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				Runtime ru = Runtime.getRuntime();
				int nNucleos = ru.availableProcessors();
				System.out.println("Número de cores " + nNucleos);

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

				Thread[] hilos = new Thread[nNucleos];

				int rango = THilo.getTam()/nNucleos; //si tam=15/8(nucleos) esa división devolvería 1 y no es correcto
												     //solución ver (*)*
				System.out.println("El rango es " + rango);
				int comienzo =0;
				int fin = rango;

				tiempoInicial = System.nanoTime();

				for (int i=0;i<nNucleos;i++)
				{
					//solución (*)* decimos si eres distinto de la última iteración haz lo previsto
					if (i != nNucleos -1)
					{
						hilos[i] = new THilo(comienzo, fin);
						hilos[i].start();
	
						comienzo = fin;
						fin += rango;
					}
					else{
						//el último hilo le obligamos a que acabe hasta el resto de la matriz
						hilos[i] = new THilo(comienzo, THilo.getTam());
						hilos[i].start();
					}
					
				}

				//tenemos que hacer esperar al hilo del main para que de tiempo a acabar a todos los hilos....con join
				for (int i=0;i<nNucleos;i++)
				{

					try {
						hilos[i].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				tiempoFinal = System.nanoTime()-tiempoInicial;//lo da en nanosegundos

				System.out.println("Ha tardado "+ (tiempoFinal/1000000)+ " milisegundos");//lo pasammos a milisegundos




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

