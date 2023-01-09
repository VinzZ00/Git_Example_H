import java.util.Scanner;
import java.util.Vector;

import classObject.Lecturer;
import classObject.People;
import classObject.Student;

public class Main {
	
	Scanner sc = new Scanner(System.in);
//	Scanner global supaya bisa di pake di satu class
	
	Vector<People> peoples = new Vector<People>(); 
//	Vector parent bisa simpen anak-anaknya, namun
//	Vector anaknya tidak bisa menyimpan saudaranya
	
	public Main() {
		// TODO Auto-generated constructor stub
		int choose;
		do {
			try {
				System.out.println("1.	Add People\n" + "2.	View People\n" + "3.	Remove People\n" + "4.	Exit\n");
				System.out.print("Choose >> ");
				choose = sc.nextInt(); //Nyimpen Inputan Integer 
				sc.nextLine(); // Nyimpen Enter
			} catch (Exception e) {
				choose = -1;
				sc.nextLine();
				System.out.println("Tolong input angka");
				sc.nextLine();
			}
			
			switch (choose) {
			case 1:
				add();
				System.out.println("Press enter to continue");
				sc.nextLine();
				break;

			case 2:
				read();
				System.out.println("Press enter to continue");
				sc.nextLine();
				break;
			case 3: 
				delete();
				System.out.println("Press enter to continue");
				sc.nextLine();
				break;
			case 4: 
				choose = 4;
				break;
			default :
				System.out.println("Please Input index number available in the menu");
				sc.nextLine();
			}
		} while (choose != 4);
		
		System.out.println("Thank you..");
		
	}
	
	public void add() {
		// Variable lokal
		String name, role;
		int age;
		double gpa, salary;
		
		do {
			System.out.print("Input name [3-15 Character] : ");
			name = sc.nextLine();
		} while (name.length() < 3 || name.length() > 15);
		
		do {
			try {
				System.out.print("Input age [min 16] : ");
				age = sc.nextInt(); sc.nextLine();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				age = -1;
				sc.nextLine();
				System.out.println("Tolong input Umur dalam bentuk angka");
				sc.nextLine();
			}
		} while (age < 16);
		
		do {
			System.out.print("Input Role [\"Student\", \"Lecturer\"] : ");
			role = sc.nextLine();
		} while (!role.equals("Student") && !role.equals("Lecturer"));
		
		if (role.equals("Student")) {
			do {
				try {
					System.out.print("Input GPA [0.00 - 4.00] : ");
					gpa = sc.nextDouble();
					sc.nextLine();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					gpa = -1;
					sc.nextLine();
					System.out.println("Tolong masukan GPA dalam bentuk angka atau decimal");
					sc.nextLine();
				} 
			} while (gpa < 0 || gpa > 4);
			
			Student s = new Student(name, role, age, gpa);
			
			peoples.add(s);
		} else {
			do {
					System.out.print("Input salary [min 4000000] : ");
				try {
					salary = sc.nextDouble(); sc.nextLine();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					salary = -1;
					sc.nextLine();
					System.out.println("Tolong input angka jangan pakai special Character");
					sc.nextLine();
				}
			} while (salary < 4_000_000);
			Lecturer l = new Lecturer(name, role, age, salary);
			peoples.add(l);
		}
	}
	
	public void read() {
		if (!peoples.isEmpty()) {
			int i = 1;
			for (People people : peoples) {

				if (people instanceof Student) {
					Student e = (Student) people;
					System.out.printf("%d. \n", i++);
					System.out.println("Hello, my name is " + e.getNama());
					System.out.printf("I am %d year(s) old\n", e.getUmur());
					System.out.println("I am a " + e.getRole());
					System.out.printf("My GPA is %.2f from 4.00\n", e.getGpa());
					System.out.println("=========================\n");
				} else {
					Lecturer e = (Lecturer) people;
					System.out.printf("%d. \n", i++);
					System.out.println("Hello, my name is " + e.getNama());
					System.out.printf("I am %d year(s) old\n", e.getUmur());
					System.out.println("I am a " + e.getRole());
					System.out.println("My salary is " + e.getSalary());
					System.out.println("=========================\n");
				}
			}
			System.out.println("--END");
		} else {
			System.out.println("no people to be displayed");
		}
	}
	
	public void delete() {
		if (!peoples.isEmpty()) {
			read();
			int idx;
			do {
				try {
					System.out.printf("Input people index to delete [0 - %d] : ", peoples.size());
					idx = sc.nextInt();
					sc.nextLine();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					idx = -1;
					sc.nextLine();
					System.out.println("Please input number");
					sc.nextLine();
				}
			} while (idx < 1 || idx > peoples.size());
			peoples.remove(idx - 1); // kenapa dikurang 1? karena mulai dari 1 dan max adalah jumlah dari array
		} else {
			System.out.println("no user to be deleted");
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
