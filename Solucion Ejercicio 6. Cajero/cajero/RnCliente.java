package cajero;

import java.util.Random;

public class RnCliente implements Runnable
{

	private CajeroAutomatico cajeroAutomatico;
	private int idCliente;

	public RnCliente(CajeroAutomatico cajeroAutomatico, int idCliente)
	{
		this.cajeroAutomatico = cajeroAutomatico;
		this.idCliente = idCliente;
	}


	@Override
	public void run()
	{
		Random random = new Random();


		while(true)
		{
			cajeroAutomatico.sacarDinero((random.nextInt(5) + 1) * 20, idCliente);
		}

	}

}
