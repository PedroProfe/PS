package ladrones;

import java.util.Random;

public class RnLadron implements Runnable
{

	private int idLadron;
	private CajaFuerte cajafuerte;

	public RnLadron(int idLadron, CajaFuerte cajaFuerte)
	{
		this.idLadron = idLadron;
		this.cajafuerte = cajaFuerte;

	}
	@Override
	public void run()
	{
		Random random = new Random();

		while(cajafuerte.robar(idLadron, random.nextInt(6) + 1));

	}

}
