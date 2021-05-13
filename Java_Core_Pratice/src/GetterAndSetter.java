
public class GetterAndSetter {

	String firstname;
	String lastname;
	String gender;
	int age;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetterAndSetter gs = new GetterAndSetter();
		gs.setFirstname("Ram");
		gs.setLastname("Swual");
		gs.setGender("Male");
		gs.setAge(25);
		
		System.out.println("Name : "+ gs.getFirstname() + " "+ gs.getLastname());
		System.out.println("Gender : "+gs.getGender());
		System.out.println("Age : "+ gs.getAge());
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
