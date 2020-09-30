package productor_consumidor;
import java.util.Random;

public class RnPonerElementos implements Runnable
{
	private Elementos elementos;
	private static boolean parar = false;
	public RnPonerElementos(Elementos elementos)
	{
		this.elementos = elementos;
	}
	@Override
	public void run()
	{
		Random random = new Random();
		while ((true) && (!parar))
		{
			elementos.ponerElemento(random.nextInt(10));
		}
	}
	public static boolean isParar() {
		return parar;
	}
	public static void setParar(boolean parar) {
		RnPonerElementos.parar = parar;
	}


}
