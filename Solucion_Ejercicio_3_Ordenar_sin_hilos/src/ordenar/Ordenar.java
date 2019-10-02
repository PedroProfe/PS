package ordenar;

public class Ordenar {

	public static void ordenar(int[] numeros)
	{
		int aux;
		boolean ordenado = false;
		for (int i = 0; i < numeros.length - 1 && !ordenado; i++)
		{
			ordenado = true;
			for (int j = 0; j < numeros.length - 1 - i; j++)
			{
				if(numeros[j] > numeros[j+1])
				{
					ordenado = false;
					aux = numeros[j];
					numeros[j] = numeros[j + 1];
					numeros[j + 1] = aux;
				}
			}
		}
	}
	
}
