package eecs2030.lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Animal {
    private static int numCreated;

    public Animal(){
	Animal.numCreated++;
    }
	
    public abstract boolean canFly();    

    public static int getNumCreated(){
        return Animal.numCreated;
    }
}

public class Fox extends Animal {
    private static int numCreated;
    
    public Fox (){
        Fox.numCreated++;
    }
    
    public String whateverFoxSays(){
        return "no one knows";
    }
    
    public static int getNumCreated(){
        return Fox.numCreated;
    }

    @Override
    public boolean canFly() {
        return false;
    }
}

public class Owl extends Animal {

    @Override
    public boolean canFly() {
        return true;
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
