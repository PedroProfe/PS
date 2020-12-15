package ejemplo_polimorfismo;

public class Empleado_Fijo extends Persona{
	
	private double salario;
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		if (salario >= 2000000){
			this.salario = 0; 
		}else{
			this.salario = salario;
		}
	}

	public Empleado_Fijo(){
		super();
	}
	
	public Empleado_Fijo(double salario){
		super();
		this.setSalario(salario);
		
	}
	
	public Empleado_Fijo(String nombre, String apellidos, int edad, double salario){
		super(nombre, apellidos, edad);
		this.setSalario(salario);
	}
	

}
