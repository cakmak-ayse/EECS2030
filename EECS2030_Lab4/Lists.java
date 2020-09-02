package eecs2030.lab4;

import java.util.Comparator;
import java.util.List;


public class Lists {
	private Lists(){} //no objects of this class are desired
	
	public static <T extends Comparable <? super T>> void defaultSort(List <T> list){
		list.sort(Comparator.naturalOrder()); //will use a built-in variation of mergesort
											//alternative: Collections.sort(list);
	}

	public static <T extends Comparable <? super T>> void selectionSortRecursive(List <T> list){
		if(list.size() < 2) {
			return;
		}
		else {
			selectionSortRecursive(list.subList(1,list.size()));
				if(list.get(1).compareTo(list.get(0)) < 0) {
				list.set(0, list.get(1));
				list.set(1, list.get(0));
			}
		
		}
		
	}
	
	

	public static <T extends Comparable <? super T>> void selectionSortIterative(List <T> list){
		//TODO implement the Iterative solution
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if(list.get(j).compareTo(list.get(i)) < 0) {
				list.set(i, list.get(j));
				list.set(j, list.get(i));
				}
			}
		}
	}

}
