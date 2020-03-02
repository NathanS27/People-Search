package main;

import java.util.Arrays;

public class ArrayListV2 {

	private static final int INITIAL_CAPACITY = 1;
	private int size = 0;
	private Person people[] = {};

	public ArrayListV2() {
		   people = new Person[INITIAL_CAPACITY];
	}
	
	public void add(Person e) {
	   if (size == people.length) {
		   increaseSize(); 
	   }
	   people[size++] = e;
	   }
	
	private void increaseSize() {
		   people=Arrays.copyOf(people, people.length+1);
	}
	
	public void delete(int i) {
	   Person[] n = new Person[people.length - 1];
	   System.arraycopy(people, 0, n, 0, i );
	   System.arraycopy(people, i+1, n, i, people.length - i-1);
	   people=new Person[n.length];
	   people=n;
	   size--;
	}
	
	public String toString() {
		String str="";
		for(Person p:people) {
			str+=String.format("%s - %d\n", p.getName(),p.getAge());
		}
		return str;
	}
	
	public int size() {
		return size;
	}
	
	public Person get(int i) {
		return people[i];
	}
	public void set(int i,Person p) {
		people[i]=p;
	}
	
}
