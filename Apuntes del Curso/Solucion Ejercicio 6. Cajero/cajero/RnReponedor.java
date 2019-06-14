package cajero;

public class RnReponedor implements Runnable
{

	private CajeroAutomatico cajeroAutomatico;
	private int saldo;
	public RnReponedor(CajeroAutomatico cajeroAutomatico, int saldo)
	{
		this.cajeroAutomatico = cajeroAutomatico;
		this.saldo = saldo;
	}
	@Override
	public void run()
	{
		while(true)
		{
			cajeroAutomatico.reponerCajero(saldo);
		}

	}

}
