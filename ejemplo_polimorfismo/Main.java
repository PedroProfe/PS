package ejemplo_polimorfismo;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Empleado_Fijo ef1 = new Empleado_Fijo(8000000);
		ef1.setNombre("Ana");
		ef1.setApellido("López");
		ef1.setEdad(40);
		Empleado_Temporal et1= new Empleado_Temporal(400000);
		Empleado_Fijo ef2 = new Empleado_Fijo("Carlos","López",60,300000);
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
		personas.add(ef1);
		personas.add(et1);
		personas.add(ef2);
		
		for (Persona p : personas) {
			
			System.out.println(p.getSalario());
			
		}
		

	}

}
