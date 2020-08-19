package eecs2030.lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Testrun {

	public static <T extends Comparable <? super T>> void mysterySort1(List <T> list){
		for (int i = 1; i < list.size(); i++){ //n 
			int j = i; //1
			
			//list.get => O(1)
			
			while (j > 0 && list.get(j - 1).compareTo(list.get(j)) > 0){ //1
				swap(list, j, j - 1); //O(1)
				j --;
			}
		}
	}
	
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
	
		private static <T extends Comparable <? super T>> boolean isSorted (List <T> list){
			T prev = list.get(0); // 1
			for (T item : list){ //n
				if (item.compareTo(prev) < 0) return false;
				prev = item;
			}
			return true;
		}
		// Thus, we can say this algorithm is O(n)

		
	private static <T extends Comparable <? super T>> void swap (List <T> list, int pos1, int pos2){
		T temp = list.get(pos1); //1
		list.set(pos1, list.get(pos2));//1
		list.set(pos2, temp);//1
	}
	// Thus, we can say that this algorithm is a constant thus O(1)
	

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(88);
		list.add(22);
		list.add(54);
		list.add(1);

	}

}
