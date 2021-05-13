package Constructor;

public class Car {
	private String brand;
	private int speed;
	private String type;
	
	Car(){}
	
	Car(String brand, String type, int speed)
	{
		this.setBrand(brand);
		this.setSpeed(speed);
		this.setType(type);
	}
	
	public void move()
	{
		System.out.println("A "+this.getBrand()+" of Type "+ this.getType() + " can travel "+this.getSpeed()+"MPH");
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
