package main;

public class Person {
	
	private String name;
	private int age;
	
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
}
