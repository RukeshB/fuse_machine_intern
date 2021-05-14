import java.util.Scanner;

public class Getting_Input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your Name: ");
		
		String name = sc.nextLine();
		
		System.out.print("Enter your age: ");
		int age = sc.nextInt();
		
		System.out.print("Enter your salary: ");
		double salary = sc.nextDouble();
		
		System.out.println("Name: "+ name);
		System.out.println("age: "+ age);
		System.out.println("salary: "+ salary);
		sc.close();
	}

}
