package eecs2030.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class sortExperiment {
	private static Random rng = new Random();

	public static void main(String[] args) {
		List <Integer> list;
		long start, end;

		//You might need to adjust the for loop parameters for different sorts individually
		for (int i = 10; i <= 10; i *= 100){ 
			list = createRandomList(i); 
			start = System.nanoTime();
			Lists.defaultSort(list);
			end = System.nanoTime();
			System.out.println("N=" + i + "\nTime spent (D): " + (end - start)/1e6 + " ms");

//			list = createRandomList(i); 
//			start = System.nanoTime();
//			Lists.selectionSortIterative(list);
//			end = System.nanoTime();
//			System.out.println("N=" + i + "\nTime spent (I): " + (end - start)/1e6 + " ms");
//
//			list = createRandomList(i); 
//			start = System.nanoTime();
//			Lists.selectionSortRecursive(list);
//			end = System.nanoTime();
//			System.out.println("N=" + i + "\nTime spent (R):" + (end - start)/1e6 + " ms");
//
			list = createRandomList(i); 
			start = System.nanoTime();
			Lists.mysterySort1(list);
			end = System.nanoTime();
			System.out.println("N=" + i + "\nTime spent (M1):" + (end - start)/1e6 + " ms");

			list = createRandomList(i); 
			start = System.nanoTime();
			Lists.mysterySort2(list);
			end = System.nanoTime();
			System.out.println("N=" + i + "\nTime spent (M2):" + (end - start)/1e6 + " ms");

			list = createRandomList(i); 
			start = System.nanoTime();
			Lists.mysterySort3(list);
			end = System.nanoTime();
			System.out.println("N=" + i + "\nTime spent (M3):" + (end - start)/1e6 + " ms\n");
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
