public class RHilo implements Runnable{

	private int id;
	private static Object obj= new Object();



	public RHilo(int id)
	{
		this.id= id;

	}



	public void run()
	{
		synchronized (obj)
		{

				try {
					obj.wait(); //esto tpoco fun
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


		}
	}

}
