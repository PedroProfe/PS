package primos;

import java.util.Iterator;
import java.util.TreeSet;

public class Almacen {
	
	TreeSet<Integer> ts;
	public Almacen() {
		ts = new <Integer>TreeSet(); 
	}
	
	public synchronized void insertar(int num) {
		ts.add(num);
	}
	
	
	public Iterator getIterador() {
		return ts.iterator();
	}

}
