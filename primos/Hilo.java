package primos;

public class Hilo extends Thread{

	int inicio,fin;
	Almacen al;
	
	public Hilo(int ini,int f,Almacen a) {
		this.inicio=ini;
		this.fin=f;
		this.al=a;
	}
	
	public void run() {
		
		for (int i = this.inicio; i < this.fin; i++) {
			if (esPrimo(i)) {
				this.al.insertar(i);
			}
		}
		
	}
	
	private boolean esPrimo(int num) {
		for (int i = 2; i < num/2; i++) {
			if (num % i==0) {
				return false;
			}
		}
		return true;
	}
}
