package singlenton;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//SIN SINGLENTON
		
		//El patrón Singlenton lo utilizamos para tener una única instancia de una clase y que esta pueda ser
		//compartida por todos. Por ejemplo una instancia que contenga la info de una bd y que todos los usuarios la 
		//compartan
		
		/*Si la lista fuera de miles de registros y llamaramos a recorrerlos varias veces no sería eficiente
		 * podríamos aplicar el patrón singlenton en PaisDAOImpl....
		 * Dentro de esa clase y dentro del método getPaises comprobamos si está instanciada la lista enorme*/
		
		/*si creara otro objeto PaisDAOImpl se volvería a ejecutar y crear la lista...me interesa no hacer esto*/
		
		/*hay que buscar la forma de no tener que instanciar PaisDAOImpl...es decir*/
		
		/*
		PaisDAOImpl dao = new PaisDAOImpl();
		for (Object obj : dao.getPaises())
		{
			System.out.println(((Pais)obj).getNombre());
		}
		
		System.out.println("***************************************************");
		
		
		
		for (Object obj : dao.getPaises())
		{
			System.out.println(((Pais)obj).getNombre());
		}
		
		
		
		PaisDAOImpl daoi = new PaisDAOImpl();
		for (Object obj : daoi.getPaises())
		{
			System.out.println(((Pais)obj).getNombre());
		}
		*/
		
		//CON SINGLENTON
		
	/*	PaisDAOImpl dao = PaisDAOImpl.getInstance(); 
		for (Object obj : dao.getPaises())
		{
			System.out.println(((Pais)obj).getNombre());
		}
		
		
		for (Object obj : dao.getPaises())
		{
			System.out.println(((Pais)obj).getNombre());
		}
		
		PaisDAOImpl daoi = PaisDAOImpl.getInstance(); 
		for (Object obj : daoi.getPaises())
		{
			System.out.println(((Pais)obj).getNombre());
		}
		
		//yo podría hacer esto
		
		//PaisDAOImpl dao2 = new PaisDAOImpl(); //hay que poner el construtor de ámbito privado
		PaisDAOImpl dao2 = PaisDAOImpl.getInstance();
		for (Object obj : dao2.getPaises())
		{
			System.out.println(((Pais)obj).getNombre());
		}
		*/
		//si quisieramos proteger una zona crítica en la que sólo un hilo se procese a la vez utilizariammos el 
		//modificador sinchronize en la zona o método que no queremos que entren 2 hilos a la vez..
		/*El patrón singlenton funciona siempre y cuando trabajemos con un único hilo a la vez lo que voy a hacer es crear
		 * 2 hilos con un Runnable y ver cómo éste código se cae*/
		
		Runnable r = new Runnable()
		{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				PaisDAOImpl dao = PaisDAOImpl.getInstance();
				for (Object obj : dao.getPaises())
				{
					System.out.println(((Pais)obj).getNombre());
				}
			}
		};
			//este código entra dos veces en la misma sección de código y crean dos instancias..
		//para protegernos de esto utilizamos el synchronize
			Thread h1 = new Thread(r);
			h1.start();
			Thread h2= new Thread(r);
			h2.start();
			
	}

}
