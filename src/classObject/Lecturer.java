package classObject;

public class Lecturer extends People {

	private double salary;

	public Lecturer(String nama, String role, int umur, double salary) {
		super(nama, role, umur);
		this.salary = salary;
		System.out.println("Lecturer added Successfully\n");
	}
	
	// Konsep Override Override dari class Parent
	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("My Salary is " + this.salary);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
}
