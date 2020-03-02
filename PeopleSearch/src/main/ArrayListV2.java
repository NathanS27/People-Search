package main;

import java.util.Arrays;

public class ArrayListV2 {

	private static final int INITIAL_CAPACITY = 1;
	private int size = 0;
	private Person people[] = {};
	private int count=0;
	private int loc;

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
	
	public void sort() {
		for(int i=0;i<size-1;i++) {
			int index=i;
			for(int j=i+1;j<size;j++) {
				if(get(j).compareTo(get(index))<0) {
					index=j;
				}
			}
			if(index!=i) {
				Person temp=get(index);
				set(index, get(i));
				set(i, temp);
			}
		}
	}
	
	public Person linearSearch(String name) {
		setCount(0);
		setLoc(0);
		for(int i=0;i<size;i++) {
			if(get(i).getName().toLowerCase().equals(name.toLowerCase())) {
				setLoc(i);
				count++;
				return get(i);
			}
			count++;
		}
		return null;
	}
	public Person binarySearch(String name) {
			setCount(0);
			setLoc(0);
			int start = 0;
			int end = size();
			int mid = (end-start)/2;
			int compare;
			while(start<end) {
				compare = get(mid).getName().toLowerCase().compareTo(name.toLowerCase());
				count++;
				if(compare==0) {
					return get(mid);
				}
				if(compare>0) {
					end = mid-1;
					mid = (end-start)/2;
				}
				if(compare<0) {
					start = mid+1;
					if(((end-start)/2)>mid) {
						mid = (end-start)/2;
					}
					else {
						mid++;
					}
				}
			}
			return null;
			
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
