package primos;

import java.util.Iterator;

public class Main {

	static final int N = 1000000;
	public static void main(String[] args) {
		
		Almacen almacen = new Almacen();
		
		Runtime runtime = Runtime.getRuntime();
		int numCores = runtime.availableProcessors();
		
		int rango = (int)Math.floor(N/numCores);
		//System.out.println(rango);
		
		int inicio = 0;
		int fin = rango;
		Hilo []h = new Hilo[numCores];
		int tiempoInicial = (int)System.currentTimeMillis();
		for (int i = 0; i < h.length; i++) {
			h[i]= new Hilo(inicio,fin,almacen);
			h[i].start();
			inicio=inicio+rango;
			fin = fin + rango;
			if (i==h.length-2) {
				fin=N;
			}
		}
		
		for (int i = 0; i < h.length; i++) {
			try {
				h[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		Iterator it = almacen.getIterador();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		int tiempoFinal = (int)System.currentTimeMillis();
		
		System.out.println("Ha tardado..."+((tiempoFinal-tiempoInicial)/1000));
	}

	

}
