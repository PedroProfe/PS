package ejemplo_polimorfismo;

public class Empleado_Temporal extends Persona{
	
	private double salario;
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		if (salario < 1000000)
			this.salario = salario * 0.10;
		else{
			this.salario = salario;
		}
	}
	public Empleado_Temporal(double salario){
			this.setSalario(salario);
	}

}
