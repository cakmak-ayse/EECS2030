package eecs2030.lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class Lists {
	private Lists(){} //no objects of this class are desired
	
	public static <T extends Comparable <? super T>> void defaultSort(List <T> list){
		list.sort(Comparator.naturalOrder()); //will use a built-in variation of mergesort
											//alternative: Collections.sort(list);
	}

	public static <T extends Comparable <? super T>> void selectionSortRecursive(List <T> list){
		//TODO implement the recursive solution
//		if(list.size() == 0) {
//			return;
//		}
//		else if (list.size() == 1) {
//			return;
//		}
//		else {
//			Lists.selectionSortRecursive(list.subList(1, list.size()));
//		}
//		List<T> help = new ArrayList<T>();
//		Collections.sort(help, new Comparator<T>(){
//			public int compare(T ai, T a2) {
////				Iterator<T> i = list.iterator();
////				T result = i.next();
////				while (i.hasNext()) {
////					T t = i.next();
////				}
//				
//				if(ai.compareTo(a2) == -1) {
//					return ai;
//				}
//				else if
//				
//				
//				
//				
//			}
//		});
//		
		
		
		
		
	}
	
	public static <T extends Comparable <? super T>> void selectionSortIterative(List <T> list){
		//TODO implement the Iterative solution
	}

}
