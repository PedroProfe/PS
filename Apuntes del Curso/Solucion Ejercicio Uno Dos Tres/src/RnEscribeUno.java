
public class RnEscribeUno implements Runnable{

	private EscribeUnoDosTres eudt;

	public RnEscribeUno(EscribeUnoDosTres eudt)
	{
		this.eudt=eudt;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true)
		{
			eudt.escribeUno();
		}

	}

}
