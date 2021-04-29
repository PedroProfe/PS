package alfil;

import java.util.Scanner;

public class Main {

	static final int N = 13;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] matriz=new int[N][N];//al declarar la matriz así, se asigna el valor de 0 a cada posición
		mostrarMatriz(matriz);
		System.out.println("Introduce posición del alfil");
		int pos = 14;//sc.nextInt();
		int fila = pos/matriz[0].length;
		int columna = pos % matriz[0].length;		
		System.out.println("fila: " + fila + " columna: "+ columna);
		
		Runtime runtime = Runtime.getRuntime();
		
		//si tenemos 8 filas y 4 hilos, el rango de filas que cada hilo pintará será 8/4
		int numCores = runtime.availableProcessors();
		
		System.out.println("El número de cores es: " + numCores);
		int rango = (int)Math.floor(N/numCores);
		System.out.println(rango);
		int posini = 0;
		int posfin = rango;
		
		Hilo []h = new Hilo[numCores];
		
		for (int i = 0; i < h.length; i++) {
			
			h[i]= new Hilo(i,fila,columna,posini, posfin,matriz); // (0,3) (3,6) (6,9) (9,13)
			h[i].start();
			posini=posfin;
			posfin=posfin+rango;
			
			if (i == h.length-2) {
				posfin = N;
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
		
		mostrarMatriz(matriz);
	}
	
	public static void mostrarMatriz(int [][]m) {
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				
				System.out.print(" " + m[i][j] + " ");	// 1  1  1  1  1 			
			}
			System.out.println();
		}
	}

}
