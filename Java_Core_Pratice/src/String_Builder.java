
public class String_Builder {

	public static void main(String[] args) {
		StringBuilder text = new StringBuilder("Hello !!!");
		
		System.out.println(text);
		
		//add Ram in text string
		text.append(" Ram");
		System.out.println("append Ram : "+text);
		
		int index = text.indexOf("Ram");
		System.out.println("index of Ram : "+index);
		
		//inserting some text after Ram
		text.insert(index+3, " How Are You ");
		System.out.println("Insert some text after Ram : "+ text);
		
		//Remove Ram from text string
		text.delete(index, (index+3));
		System.out.println("Remove Ram : "+text);
	}

}
