package coordinacion;

public class AlmacenComunEscritura {

	int contador;
	
	public AlmacenComunEscritura()
	{
		this.contador=0;
	}
	public synchronized void escribirHilo(int i)
	{		
		while (i != contador)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}			
		}
		System.out.println("Hola soy el hilo " + i);
		contador++;
		notifyAll();		
	}
	
}
