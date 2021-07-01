package junit_gradle.mockito;

public class ComplexCalculation {
	BasicCalculation basicCal;
	
	public ComplexCalculation(BasicCalculation basicCal)
	{
		this.basicCal = basicCal;
	}
	
	public int calculate1(int a,int b)
	{
		return basicCal.add(basicCal.multiply(a, b), a);
	}
	
	public int calculate2(int a,int b,int c,int d)
	{
		int multiply1 = basicCal.multiply(a, b);
		int multiply2 = basicCal.multiply(c, d);
		int result = basicCal.add(multiply1, multiply2);
		return result;
	}
	
	public double calculate3(int a, int b,int c)
	{
		int multiply = basicCal.multiply(a, b);
		double result  = basicCal.divide(multiply, c);
		return result;
	}
}
