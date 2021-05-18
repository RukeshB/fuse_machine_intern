import java.util.LinkedList;

public class LinkListPratice {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("Ram");
		list.add("shyam");
		list.add("hari");
		
		//remove first element
		list.remove();
		
		// add element to specific index
		list.add(1, "sita");
		
		//get element in index 0
		String name = list.get(0);
		System.out.println(name);
		
		//return first element of list
		System.out.println(list.getFirst());
		
		//return last element of list
		System.out.println(list.getLast());
		
		//return the index of element
		System.out.println(list.indexOf("shyam"));
		
		System.out.println(list);
	}

}
