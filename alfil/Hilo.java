package alfil;

public class Hilo extends Thread {

	int fila,columna,posIni,posFin,idHilo;
	int [][]mat;
	
	public Hilo(int idhilo, int fil, int column, int posini, int posfin, int [][] matr) {
		this.mat = matr;
		this.fila = fil;
		this.columna= column;
		this.posIni=posini;
		this.posFin=posfin;	
		this.idHilo=idhilo;
	}
	
	public void run() {
		
		for (int i = this.posIni; i < this.posFin; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				
				if ((this.fila + this.columna)==(i + j) || (this.fila-this.columna)==(i-j)) {
					this.mat[i][j]=1;
				}
			}
		}
	}
	
}
