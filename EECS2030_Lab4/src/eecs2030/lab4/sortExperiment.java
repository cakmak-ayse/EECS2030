package eecs2030.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class sortExperiment {
	private static Random rng = new Random();

	public static void main(String[] args) {
		List <Integer> list;
		long start, endI, endD, endR;

		//You might need to change the 1M value to something smaller for other sorts
		for (int i = 10; i <= 10_000; i *= 10){ 
			list = createRandomList(i); 
			start = System.nanoTime();
			
			Lists.defaultSort(list);
			endD = System.nanoTime();
			
			Lists.selectionSortIterative(list);
			endI = System.nanoTime();
			
			Lists.selectionSortRecursive(list);
			endR = System.nanoTime();
			
			System.out.println("N=" + i + "\nDefault Sort, Time spent: " + (endD - start)/1e6 + " ms");
			System.out.println("Selection-Iterative, Time spent: " + (endI - start)/1e6 + " ms");
			System.out.println("Selection-Recursive, Time spent: " + (endR - start)/1e6 + " ms");
		}
	}

	private static List <Integer> createRandomList (int size){
		rng.setSeed(8);
		List <Integer> list = new ArrayList<>();
		
		for (int i = 0; i < size; i++) {
			list.add(rng.nextInt());
		}
		return list;
	}


}
