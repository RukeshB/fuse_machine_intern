import java.io.IOException;
import java.util.Scanner;

public class calculator {

	public void add(double a, double b)
	{
		System.out.println(a + " + " + b +" = "+(a+b));
	}
	
	public void subtract(double a, double b)
	{
		System.out.println(a + " - " + b +" = "+(a-b));
	}
	
	public void Divide(double a, double b)
	{
		System.out.println(a + " / " + b +" = "+(a/b));
	}
	
	public void Multiply(double a, double b)
	{
		System.out.println(a + " * " + b +" = "+(a*b));
	}
	
	public static void clearScreen() {  
		System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculator cal = new calculator();
		
		Scanner input = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1. Add \n 2. subtract \n 3. Multiply \n 4. Divide \n 5. exit Program");
			System.out.print("Enter Number to Select the option: ");
			
			int option = input.nextInt();
			
			double a=0,b=0;
			if(option != 5)
			{
				System.out.print("Enter First Number: ");
				a= input.nextDouble();
				
				System.out.print("Enter second Number: ");
				b= input.nextDouble();
			}
			
			switch(option)
			{
				case 1:
				{
					cal.add(a,b);
					break;
				}
				case 2:
				{
					cal.subtract(a, b);
					break;
				}
				case 3:
				{
					cal.Multiply(a, b);
					break;
				}
				case 4:
				{
					cal.Divide(a, b);
					break;
				}
				case 5:
				{
					System.exit(0);
					break;
				}
				default:
				{
					System.out.println("Enter Valid Option !!!");
				}
			}
			clearScreen();
		}
		
	}

}
