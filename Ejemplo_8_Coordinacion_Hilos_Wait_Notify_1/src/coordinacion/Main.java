package coordinacion;

public class Main {

	public static void main(String[] args) {
			
			
	   THilo []h = new THilo[10];
	   AlmacenComunEscritura ace = new AlmacenComunEscritura();
		
		for (int i = 0; i<h.length;i++)
		{
			h[i]=new THilo(i,ace);
			h[i].start();
		}
		
		
		try{
			for (int i = 0; i<h.length;i++)
			{				
				h[i].join();
			}
		
		}catch (Exception ex){}	
	}
}
