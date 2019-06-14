
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				Thread[] hilos = new Thread[10];

				for (int i=0;i <hilos.length; i++){

					hilos[i] = new Thread(new RHilo(i));
					hilos[i].start();
				}

				for (int i=0;i <hilos.length; i++){
					try {
						hilos[i].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				System.out.println("Soy el hilo principal");
	}

}
