package ping_pong;

public class RnEscribePong implements Runnable
{

	private EscribePingPong escribePingPong;
	public RnEscribePong(EscribePingPong escribePingPong)
	{
		this.escribePingPong = escribePingPong;
	}
	@Override
	public void run()
	{
		while(true)
		{
			escribePingPong.escribePong();
		}

	}

}
