package Calculator;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Calculator_operation cal = new Calculator_operation();
		
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

			input.close();
		}
		
	}

}
