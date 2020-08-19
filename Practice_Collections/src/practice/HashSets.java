package practice;

import java.util.HashSet;
import java.util.Set;

public class HashSets {

	public boolean testHashSetisEmpty(Set<String> list){
		Set<String> listSet = new HashSet<String>();
		listSet.addAll(list);
		
		if(listSet.isEmpty()) {
			return true;
		}
		return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
