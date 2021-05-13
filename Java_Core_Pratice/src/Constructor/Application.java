package Constructor;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car carObject = new Car("Ford" , "Sprots" , 600);
		carObject.move();
		
		carObject = new Car("lamborghini" , "Sprots" , 750);
		carObject.move();
	}

}
