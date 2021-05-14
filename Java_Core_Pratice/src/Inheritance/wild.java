package Inheritance;

public class wild implements Animal{

	public void harmful()
	{
		System.out.println("wild animal is harmful");
	}

	@Override
	public void eat() {
		System.out.println("Most wild animal eats raw meat");
	}
}
