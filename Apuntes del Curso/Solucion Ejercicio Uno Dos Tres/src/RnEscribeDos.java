
public class RnEscribeDos implements Runnable{

	private EscribeUnoDosTres eudt;

	public RnEscribeDos(EscribeUnoDosTres eudt)
	{
		this.eudt=eudt;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true){
			eudt.escribeDos();
		}

	}

}
