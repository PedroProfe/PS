
public class THilo extends Thread {

	private  int _id;
	public THilo(int id)
	{
		this._id=id;		
	}
	
	public void run()
	{
		System.out.println("Soy el hilo "+ _id);
	}
}
