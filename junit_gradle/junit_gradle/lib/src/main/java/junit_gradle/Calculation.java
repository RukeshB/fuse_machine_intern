package junit_gradle;

public class Calculation {

	public int add(int a,int b)
	{
		return a+b;
	}
	
	public double divide(int a, int b)
	{
		return a/b;
	}
	
	public int multiply (int a , int b)
	{
		return a*b;
	}
	
	public double areaOfCircle(double radius)
	{
		return Math.PI * Math.pow(radius, 2);
	}
}
