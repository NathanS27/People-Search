package main;

import java.util.Arrays;

public class PeopleList {

	private static final int INITIAL_CAPACITY = 1;
	private int size = 0;
	private Person people[] = {};
	private int comparisons=0;
	private int loc;

	public PeopleList() {
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
		setComparisons(0);
		setLoc(0);
		for(int i=0;i<size;i++) {
			comparisons++;
			switch(get(i).getName().compareToIgnoreCase(name)) {
			case -1:
				//if name comes later in the array
				break;
			case 0:
				return get(i);
			case 1:
				//if searching past where name should be,not found
				return null;
			}
		}
		//ran out of items to search, name not found
		return null;
	}
	public Person binarySearch(String name) {
			setComparisons(0);
			setLoc(0);
			int start = 0;
			int end = size();
			int mid = (end-start)/2;
			int compare;
			while(start<end) {
				compare = get(mid).getName().toLowerCase().compareTo(name.toLowerCase());
				comparisons++;
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
	public int getComparisons() {
		return comparisons;
	}
	public void setComparisons(int comparisons) {
		this.comparisons = comparisons;
	}
	public int getLoc() {
		return loc;
	}
	public void setLoc(int loc) {
		this.loc = loc;
	} 
}
