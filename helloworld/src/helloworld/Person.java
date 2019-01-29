package helloworld;

public class Person {

	private String name;
	private String firstName;
	private String lastName;
	private int age;
	
	public Person() {}
	
	public Person(String _name, int _age)
	{
		name = _name;
		age = _age;
	}
	public Person(String fname, String lname, int _age)
	{
		firstName = fname;
		lastName = lname;
		age = _age;
	}
	
	public String getLastName() {return lastName;}
	public void setLastName(String lname) {lastName = lname;}
	
	public String getFirstName(){return firstName;}
	public void setFirstName(String fname) {firstName = fname;}
	
	public String getName() {return name;}
	public void setName(String _pname) {name = _pname;}
	
	public int getAge() {return age;}
	public void setAge(int _page) {age = _page;}
}
