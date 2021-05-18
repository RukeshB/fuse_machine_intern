import java.util.HashMap;

public class HashMapPratice {

	public static void main(String[] args) {
		HashMap<Integer,String> hash = new HashMap<Integer,String>();
		hash.put(1, "Ram");
		hash.put(2, "Shyam");
		hash.put(3, "Hari");
		
		//get value using key 
		System.out.println(hash.get(1));
		
		//remove element using key of value
		hash.remove(2);
		
		//replace a value of specific key
		hash.replace(3, "sita");
		
		//return number of element
		int num = hash.size();
		System.out.println(num);
		
		System.out.println(hash);
	}

}
