package hilos_parametros;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		THilo h1 = new THilo(1);
		THilo h2 = new THilo(2);
		THilo h3 = new THilo(3);
		h1.start();
		h2.start();
		h3.start();

		/*Todos los hilos ejecutarán su run a la vez. No hay forma de saber cuál se ejecutará antes y cual después
		  El main le va diciendo al sistema operativo oye lanza un hilo h1 y luego el h2...esas llamadas al SO llevan
		  su tiempo y además los hilos no se tienen que ejecutar cuando se lanzan es por eso que se ejecuta a veces
		  el hilo 2 antes que el hilo 1.

		   NO sabemos nunca el orden de ejecución de los hilos.

		   En este ejemplo el main se ejecuta en su propio hilo y éste lanza los hilos h1 h2 h3. Esto significa que el
		   main le dice al SO oye ejecuta esto cuando puedas. Estos hilos h1 h2 h3 serán hilos secundarios, el principal
		   es el que ejecuta el public static main()*/


		System.out.println("Hilo del main sigue su ejecución de forma paralela al resto de los hilos");

	}

}
