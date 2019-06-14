public class RHilo implements Runnable{

	private int id;
	private static Object obj= new Object();
	private static int cont=0;


	public RHilo(int id)
	{
		this.id= id;

	}

	//la idea de este ejercicio es controlar el orden en que pueden ejecutar el println del método run,
	/*
	@Override
	public void run() esto es sin ordden
	{

		System.out.println("soy el hilo " + this.id);
	}*/

	/*En este ejercicio creamos un cerrojo (tiene que ser un objeto de cualquer clase instanciado, pero lo deben
	 * compartir todos los hilos, por lo que debe ser static. Yo me he creado un objtect
	 *
	 * Una primera aproximación sería este run...pero tpoco funciona....*/

	//esto no funcionará pq si llega el 4 y no es igual a cont se salta el if y el syn y no vuelve
	  //tenemos que hacer algo para que ese hilo se vuelva a la cola

	/*
	public void run()
	{
		synchronized (obj)
		{
			if (this.id==cont)
			{
				System.out.println("Soy el hilo " + this.id);
				cont++;
			}

		}
	}*/
	
	/*
	 * En este run creamos dos colas de hilos, una la cola que proboca el synchronized y otra la cola que provoca el cerrojo
	 * En la cola del synchronized van a estar todos aquellos hilos que están esperando entrar y en la cola del cerrojo 
	 * van a estar todos aquellos hilos que entraron y que eran distintos de cont. Cuando un hilo que igual a cont ejecuta
	 * el println libera al resto de hilos que hay en el synchronized y el más rápido pasará, pero que pasa con los hilos que 
	 * se quedaron esperando en la otra cola generada por el obj.wait()?.. Éstos han de ser liberados para que vuelvan a la cola
	 * esto lo hacemos con obj.notifyAll. De esta forma entran de nuevo en la cola del syncronized.
	 * 
	 * ESTA SOLUCIÓN TPCO FUNCIONA PQ LOS QUE SE QUEDARON ESPERANDO EN EL OBJ.WAIT AL SER LIBERADOS HACEN EL PRINT.
	 * HAY QUE IMPLEMENTAR UNA CONDICIÓN DE GUARDA */
	
	/*public void run()
	{
		synchronized (obj)
		{
			if (this.id != cont)
			{
				try {
					obj.wait(); //esto tpoco fun
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
				System.out.println("Soy el hilo " + this.id);
				cont++;	
				obj.notifyAll(); //ESTE NOTIFYALL SOLO DESPIERTA A LOS HILOS QUE ESTAN DURMIENDO EN EL OBJ.WAIT NO A LOS
								//HILOS DEL SYNCHRONIZED
		}
	}*/
	
	/*En esta solución sí que implementamos una condición de guarda...esto lo podemos arreglar sustituyendo el if por
	 * el while*/
	
	public void run()
	{
		synchronized (obj)
		{
			while(this.id != cont)
			{
				try {
					obj.wait(); //esto tpoco fun
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
				System.out.println("Soy el hilo " + this.id);
				cont++;	
				obj.notifyAll(); //ESTE NOTIFYALL SOLO DESPIERTA A LOS HILOS QUE ESTAN DURMIENDO EN EL OBJ.WAIT NO A LOS
								//HILOS DEL SYNCHRONIZED
		}
	}

}
