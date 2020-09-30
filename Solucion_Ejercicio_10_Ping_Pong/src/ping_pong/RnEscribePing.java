package ping_pong;

public class RnEscribePing implements Runnable
{

	private EscribePingPong escribePingPong;
	public RnEscribePing(EscribePingPong escribePingPong)
	{
		this.escribePingPong = escribePingPong;
	}
	@Override
	public void run()
	{
		while(true)
		{
			escribePingPong.escribePing();
			try
			{
				Thread.sleep(500);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
