package practice;

import java.util.Set;
import java.util.TreeSet;

public class TreeSets {
	public Set<String> cloneTreeSet(Set<String> list) {
		Set<String> one = new TreeSet<String>();
		Set<String> two = new TreeSet<String>();
		
		one.addAll(list);
		System.out.println("Tree list: " + one);             

		two.addAll(one);
		
		return two;
		
		
	}
	public static void main(String[] args) {
		Set<String> list = new TreeSet<String>();
		list.add("Red");
		list.add("Green");  
		list.add("Black");   
		list.add("Pink");
		list.add("orange"); 
		
		TreeSets test = new TreeSets();
		System.out.println("Cloned tree list: " + test.cloneTreeSet(list));             
		          
	}

}
