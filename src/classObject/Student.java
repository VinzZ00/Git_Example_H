package classObject;

public class Student extends People {
		
	private double gpa;

	public Student(String nama, String role, int umur, double gpa) {
		super(nama, role, umur);
		this.gpa = gpa;
		System.out.println("Student added Successfully\n");
	}

	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.printf("My GPA is %.2f from 4.00\n", this.gpa);
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
	

}
