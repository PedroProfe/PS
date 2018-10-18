
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		THilo[] vec = new THilo[1000];

		for (int i=0;i <vec.length; i++){
			vec[i] = new THilo();
			vec[i].start();
		}

		/*El problema es que se va a ejecutar la linea de abajo cuando todabía se están
		 * ejecutando los hilos que lanzó...además incluso aunque lo solucionemos con
		 * un join...los hilos podrían acceder al mismo tiempo a la variable cont*/

		/*Solución parcial, sigue sin funcionar incluso con el for de abajo*/
		for (int i=0;i <vec.length; i++){
			try {
				vec[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*la razón por la cual ni con el join funcione es por el indeterminismo y esto
		ocurre cuando dos o más hilos intentan escribir en una variable compartida
		se produce indeterminación, ¿Por qué ocurre est? porque si 3 hilos accedieron
		a la vez y leyeron la variable a la vez con un valor por ejemplo 100, al incrementar
		el valor escribirán 101 y no lo que correspondería "103". */
		System.out.println("El valor de cont es "+ THilo.getCont());
	}

}
