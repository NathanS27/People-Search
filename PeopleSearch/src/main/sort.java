package main;

public class sort {
	
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
		int count=0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
				list.get(i).setCount(count);
				list.get(i).setLoc(i);
				return list.get(i);
			}
			count++;
		}
		return null;
	}
	public Person binarySeach(String name,ArrayListV2 list) {
		
	}
}

