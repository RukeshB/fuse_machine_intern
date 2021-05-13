package Calculator;

public class Calculator_operation {
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
		double sub = num[0];
		for(int i=1;i<num.length;i++)
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
}
