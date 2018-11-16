
public class Lista
{
	private int[] lista;
	private int posicion;
	public Lista(int numCorredores)
	{
		lista = new int[numCorredores];
		posicion  = 0;
	}
	public synchronized void apuntarCorredor(int dorsal)
	{
		lista[posicion] = dorsal;
		posicion++;
	}

	public int[] getResultados()
	{
		return lista;
	}
}
