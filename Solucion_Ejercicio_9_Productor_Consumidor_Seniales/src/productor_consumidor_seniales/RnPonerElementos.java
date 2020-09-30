package productor_consumidor_seniales;
import java.util.Random;

public class RnPonerElementos implements Runnable
{
	private Elementos elementos;
	public RnPonerElementos(Elementos elementos)
	{
		this.elementos = elementos;
	}
	@Override
	public void run()
	{
		Random random = new Random();
		while(true)
		{
			elementos.ponerElemento(random.nextInt(10));
		}
	}
}
