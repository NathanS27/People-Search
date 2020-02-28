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
		Person[] temp = people;
		int count=0;
		people = new Person[size-1];
		for(int k=0;k<people.length;k++) {
			if(k!=i) {
				people[count]=temp[k];
			}
		}
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
