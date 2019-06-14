
public class Main {

	static final int numHilos=8;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Contador_Hilos contador;//es la variable que compartirán todos los hilos
		contador= new Contador_Hilos();

		Thread[] h = new Thread[numHilos];//

		for (int i=0;i<numHilos;i++)
		{
			h[i] = new Thread(new RHilo(contador));
			h[i].start();
		}


		for (int i=0;i<numHilos;i++)
		{
			try {
				h[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Hilos terminados, el contador a quedado con " + contador.valorContador());

	}

}
