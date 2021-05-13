
import java.util.Scanner;

public class calculator {

	public double add(double[] num)
	{
		double sum = 0;
		for(int i=0;i<num.length;i++)
		{
			sum += num[i];
		}
		return sum;
		//System.out.println(a + " + " + b +" = "+(a+b));
	}
	
	public double subtract(double[] num)
	{
		double sub = 0;
		for(int i=0;i<num.length;i++)
		{
			sub -= num[i];
		}
		return sub;
		//System.out.println(a + " - " + b +" = "+(a-b));
	}
	
	public double Divide(double[] num)
	{
		double div = num[0];
		for(int i=1;i<num.length;i++)
		{
			div = div/num[i];
		}
		return div;
		//System.out.println(a + " / " + b +" = "+(a/b));
	}
	
	public double Multiply(double[] num)
	{
		double mul = 1;
		for(int i=0;i<num.length;i++)
		{
			mul *= num[i];
		}
		return mul;
		//System.out.println(a + " * " + b +" = "+(a*b));
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
			
			double[] num;
			num= new double[0];
			int n=0;
			double result=0;
			if(option == 1 || option == 2 || option == 3 || option == 4)
			{
				System.out.print("Enter How many Number: ");
				n= input.nextInt();
				
				num= new double[n];
				for(int i=0;i<n;i++)
				{
					System.out.print("Enter Number["+(i+1)+"]: ");
					num[i]= input.nextDouble();
				}
				
			}
			
			switch(option)
			{
				case 1:
				{
					result = cal.add(num);
					break;
				}
				case 2:
				{
					result=cal.subtract(num);
					break;
				}
				case 3:
				{
					result=cal.Multiply(num);
					break;
				}
				case 4:
				{
					result=cal.Divide(num);
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
			
			if(option == 1 || option == 2 || option == 3 || option == 4)
			{
				System.out.println("Result = "+ result);
			}
			clearScreen();
		}
		
	}

}
