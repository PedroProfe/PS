package indeterminismo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlmacenContador ac = new AlmacenContador();
		THilo[] vec = new THilo[1000];

		for (int i=0;i <vec.length; i++){
			vec[i] = new THilo(ac);
			vec[i].start();
		}


		
		/*Con join esperamos a que acaben todos los hilos desde el hilo del main, de otro modo el 
		 * main podría terminar antes dando un resultado erroneo*/

		for (int i=0;i <vec.length; i++){
			try {
				vec[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("El valor de cont es "+ ac.getContador());
	}

}
