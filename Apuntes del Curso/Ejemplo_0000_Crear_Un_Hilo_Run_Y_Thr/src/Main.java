
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		THilo h1 = new THilo(1);
		h1.start();
		
		Thread h2 = new Thread(new RHilo(2));
		h2.start();
		
		//otra forma de crear hilos es instanciar un objeto de la interfaz Runable
		Runnable r = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i=0;i<100;i++)
				{
					System.out.println("[A] Hilo ejecutandose." + i);
				}

			}			
		};
		
		Thread h3 = new Thread (r);
		h3.start();
		
		for (int i=0;i<100;i++)
		{
			System.out.println("Ejecutandose hilo Main..." + i);
		}

	}

}
