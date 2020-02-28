package main;

public class Person{
	
	private String name;
	private int age;
	private int count;
	private int loc;
	
	public Person(String nm, int num) {
		name=nm;
		age=num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int compareTo(Object obj) {
		return name.toLowerCase().compareTo(((Person)obj).getName().toLowerCase());
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getLoc() {
		return loc;
	}

	public void setLoc(int loc) {
		this.loc = loc;
	}
}
