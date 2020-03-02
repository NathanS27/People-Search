package main;

public class sort {
	
	private int count=0;
	private int loc;
	
	public ArrayListV2 sortNames(ArrayListV2 list){
		int size=list.size();
		for(int i=0;i<size-1;i++) {
			int index=i;
			for(int j=i+1;j<size;j++) {
				if(list.get(j).compareTo(list.get(index))<0) {
					index=j;
				}
			}
			if(index!=i) {
				Person temp=list.get(index);
				list.set(index, list.get(i));
				list.set(i, temp);
			}
		}
		return list;
	}
	public Person linearSearch(String name,ArrayListV2 list) {
		count=0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
				list.get(i).setLoc(i);
				count++;
				return list.get(i);
			}
			count++;
		}
		return null;
	}
	public Person binarySearch(String name,ArrayListV2 list) {
			count=0;
			int start = 0;
			int end = list.size();
			int mid = (end-start)/2;
			int compare;
			while(start<end) {
				compare = list.get(mid).getName().toLowerCase().compareTo(name.toLowerCase());
				count++;
				if(compare==0) {
					return list.get(mid);
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

