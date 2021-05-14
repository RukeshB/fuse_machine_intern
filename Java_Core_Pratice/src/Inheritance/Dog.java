package Inheritance;

public class Dog extends Domestic{

	@Override
	public void eat() {
		System.out.println("Dog eat Bone");
	}

	public void bark()
	{
		System.out.println("Bark !!!");
	}
}
