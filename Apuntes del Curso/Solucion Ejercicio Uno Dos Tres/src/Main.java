
public class Main {

	public static void main(String[] args) {
		EscribeUnoDosTres eudt= new EscribeUnoDosTres();


		Thread huno = new Thread(new RnEscribeUno(eudt));
		Thread hdos = new Thread(new RnEscribeDos(eudt));
		Thread htres = new Thread(new RnEscribeTres(eudt));
		
		huno.start();
		hdos.start();
		htres.start();

	}

}
