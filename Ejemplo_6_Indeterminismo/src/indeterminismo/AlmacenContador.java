package indeterminismo;

public class AlmacenContador {
	
	private int contador;
	
	public AlmacenContador()
	{
		contador = 0;
	}
	
	public void incrementaContador()
	{
		contador++;
	}
	
	public int getContador()
	{
		return contador;
	}

}
