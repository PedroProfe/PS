package cajero;

import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Número de clientes: ");
		int numClientes = sc.nextInt();
		int saldoReposicion;
		do
		{
			System.out.print("Saldo de reposición del cajero (múltiplos de 20): ");
			saldoReposicion = sc.nextInt();
		}
		while(saldoReposicion % 20 != 0 || saldoReposicion == 0);
		sc.close();

		CajeroAutomatico cajeroAutomatico = new CajeroAutomatico();

		new Thread(new RnReponedor(cajeroAutomatico, saldoReposicion)).start();


		for (int i = 0; i < numClientes; i++)
		{
			new Thread(new RnCliente(cajeroAutomatico, i + 1)).start();
		}

	}

}
