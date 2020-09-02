package eecs2030.lab7;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lists {
	private Lists(){} //no objects of this class are desired

	public static <T extends Comparable <? super T>> void defaultSort(List <T> list){
		list.sort(Comparator.naturalOrder()); //will use a built-in variation of mergesort
		//alternative: Collections.sort(list);
	}

	public static <T extends Comparable <? super T>> void selectionSortRecursive(List <T> list){
		if(list.size() > 1){
			swap (list, 0, findMinPos(list, 0, list.size())); //"minToFront()"
			selectionSortRecursive(list.subList(1, list.size()));
		}
	}

	public static <T extends Comparable <? super T>> void selectionSortIterative(List <T> list){
		for (int i = 0; i < list.size(); i++){
			swap(list, i, findMinPos(list, i, list.size()));
		}
	}

	
	//Mystery 1    Insertion Sort
	public static <T extends Comparable <? super T>> void mysterySort1(List <T> list){
		for (int i = 1; i < list.size(); i++){ //n
			int j = i; //1
			
			//list.get => O(1)
			
			while (j > 0 && list.get(j - 1).compareTo(list.get(j)) > 0){ //
				swap(list, j, j - 1); //O(1)
				j --;
			}
		}
	}

	
	//Mystery 2
	public static <T extends Comparable <? super T>> void mysterySort2(List <T> list){
		int h = 1;
		while (h < list.size() / 3) {
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
		}
		while (h >= 1) { // "h-sort" the list.
			for (int i = h; i < list.size(); i++){ //n
				int j = i;
				while (j >= h && list.get(j - h).compareTo(list.get(j)) > 0){
					swap(list, j, j - h);
					j -= h;
				}
			}
			
			h = h / 3;
		}
	}

	
	//Mystery 3 Bubble Sort???
	public static <T extends Comparable <? super T>> void mysterySort3(List <T> list){
		while (!isSorted(list)){ // O(n)
			Collections.shuffle(list); //O(n)
		}
	}
	// O(n) + O(n) = O(n^2)
	

	/**
	 * returns the position of the min element in the list
	 * @param list
	 * @param from from (inclusive)
	 * @param to to (exclusive)
	 * @return position of the min element in the list (-1 if empty)
	 */
	private static <T extends Comparable <? super T>> int findMinPos(List <T> list, int from, int to){
		if (list.isEmpty()) return -1;
		if (from < 0 || to > list.size()) throw new IllegalArgumentException();
		T currentMin = list.get(from);
		int currentMinPos = from;
		for (int i = from; i < to; i++){
			if (list.get(i).compareTo(currentMin) < 0){
				currentMin = list.get(i);
				currentMinPos = i;
			}
		}
		return currentMinPos;
	}

	private static <T extends Comparable <? super T>> void swap (List <T> list, int pos1, int pos2){
		T temp = list.get(pos1); //1
		list.set(pos1, list.get(pos2));//1
		list.set(pos2, temp);//1
	}
	// Thus, we can say that this algorithm is a constant thus O(1)
	

	private static <T extends Comparable <? super T>> boolean isSorted (List <T> list){
		T prev = list.get(0); // 1
		for (T item : list){ //n
			if (item.compareTo(prev) < 0) return false;
			prev = item;
		}
		return true;
	}
	// Thus, we can say this algorithm is O(n)

}
