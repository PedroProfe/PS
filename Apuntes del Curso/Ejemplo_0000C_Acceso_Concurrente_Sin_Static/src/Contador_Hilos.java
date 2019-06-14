
public class Contador_Hilos {

	int cont;

	public Contador_Hilos()
	{
		cont=0;
	}

	public synchronized void incrementaContador()
	{
		cont++;
	}

	public int valorContador()
	{
		return cont;
	}
}
