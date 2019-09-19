package singlenton;
import java.awt.List;
import java.util.ArrayList;

public class PaisDAOImpl {
	
	private ArrayList paises = null;
	public static PaisDAOImpl instancia = null;
	
	public ArrayList getPaises()
	{
		if (paises == null) //con esta comprobación estamos aplicando el patrón singlenton
			//si no lo pusieramos crearía otra vez la lista y metería los datos y ocuparía doble en memoria
			//de est forma el método al comprobar que no esta vacio devolveria directamente la lista que se llenó 
			//la  primera vez que se instanció
		{
			paises = new ArrayList(); 
			Pais p1 = new Pais("PERU");
			Pais p2 = new Pais("MEXICO");
			Pais p3 = new Pais("COLOMBIA");
			
			paises.add(p1);
			paises.add(p2);
			paises.add(p3);
		}
		return paises;
	}
	
	/*necesitamos un método que me retorne una única instancia de esa clase..hay q implementar el patrón singlenton aquí*/
	
	
	
	public static  synchronized PaisDAOImpl getInstance()
	{
		//los hilos entran a la vez y ejecutan la lista....hay que poner el synchronize para indicar que no se entre aquí
		/*
		  más de un hilo a la vez...como el elemento es static no podemos poner sinchronize(this...) hay que poner 
		  en su lugar synchronize(Main.class)*/
		//synchronized(Main.class){ //esto tb funciona, pero como lo he puesto en el método...eso tb vale
			if (instancia == null)
			{
					instancia = new PaisDAOImpl();
					System.out.println("Se ha creado la instancia...");
			}
		//}
		return instancia;
	}
	
	private PaisDAOImpl()
	{}

}
