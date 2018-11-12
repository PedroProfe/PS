
public class RnEscribeTres implements Runnable {

	private EscribeUnoDosTres eudt;

	public RnEscribeTres(EscribeUnoDosTres eudt)
	{
		this.eudt=eudt;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true)
		{
			eudt.escribeTres();
		}
	}

}
