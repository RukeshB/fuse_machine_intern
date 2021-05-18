
public class Polymorphism {

	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		int c =2;
		int d =4;
		
		System.out.println(a+"+"+b+" = "+add(a,b));
		System.out.println(a+"+"+b+"+"+c+" = "+add(a,b,c));
		System.out.println(a+"+"+b+"+"+c+"+"+d+" = "+add(a,b,c,d));
	}

	public static int add(int a, int b)
	{
		return a+b;
	}
	
	public static int add(int a, int b , int c)
	{
		return a+b+c;
	}
	
	public static int add (int a, int b, int c,int d)
	{
		return a+b+c+d;
	}
}
