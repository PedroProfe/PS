package cajero;

public class CajeroAutomatico
{
	private int saldo;



	private final int TURNO_CLIENTES = 0;
	private final int TURNO_REPONEDOR = 1;

	private int turno = TURNO_REPONEDOR;


	public CajeroAutomatico()
	{
		// El saldo inicial del cajero es 0
		this.saldo = 0;
	}
	public synchronized void sacarDinero(int extraer, int idCliente)
	{

		if(turno == TURNO_CLIENTES)
		{


			// Si hay saldo suficiente
			if(extraer <= saldo)
			{
				saldo -= extraer;
				System.out.println("Cliente " + idCliente + ". He retirado " + extraer +
						" euros. Quedan " + saldo + " euros.");

				if(saldo == 0)
				{
					turno = TURNO_REPONEDOR;
				}


			}
			else // No hay saldo suficiente en el cajero
			{
				System.out.println("Cliente " + idCliente + ". No puedo sacar " + extraer + " euros.");
			}
		}
		notify();
		try	{wait();} catch (InterruptedException e){}
	}

	public synchronized void reponerCajero(int saldo)
	{

		if(turno == TURNO_REPONEDOR)
		{

			System.out.println("Recargado el saldo en " + saldo + " euros.");
			this.saldo = saldo;

			turno = TURNO_CLIENTES;

		}
		notify();
		try	{wait();} catch (InterruptedException e){}
	}


}
