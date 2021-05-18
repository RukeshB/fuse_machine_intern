import java.util.ArrayList;

public class ArrayListPratice {

	public static void main(String[] args) {
		ArrayList<String> cars = new ArrayList<String>();
		
		//add element
		cars.add("Bmw");
		cars.add("Bentley");
		cars.add("Tesla");
		
		//add to specific index
		cars.add(0,"Ford");
		
		//Find the index of specific element 
		int index = cars.indexOf("Ford");
		System.out.println(index);
		
		//replace an element in specific index
		cars.set(1, "Audi");
		
		//return an element in specific index
		String car = cars.get(index);
		System.out.println(car);
		
		//remove an element in specific index 
		cars.remove(2);
		
		System.out.println(cars);
	}

}
