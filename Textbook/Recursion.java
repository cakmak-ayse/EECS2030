package questions;

//import java.util.ArrayList;
import java.util.List;

public class Recursion {
	public static boolean contains(String element, List<String> t) {
		boolean result;
		if (t.size() == 0) {
		result = false;
		}
		else if (t.get(0).equals(element)) {
		result = true;
		}
		else {
		result = Recursion.contains(element, t.subList(1, t.size()));
		}
		return result;
	}
	
	public static int min(List<Integer> t) {
		if (t.isEmpty()) {
		throw new IllegalArgumentException();
		}
		Integer first = t.get(0);
		if (t.size() == 1) {
		return first;
		}
		Integer minInRest = min(t.subList(1, t.size()));
		if (first.compareTo(minInRest) < 0) { // “<=” ?
			return first;
		}
		return minInRest;
	}
	
	
	

	public static void main(String[] args) {
//		List <Integer> g = new ArrayList<Integer>();
//		g.add(1);
//		g.add(2);
//		g.add(0);
//		System.out.print(Recursion.contains("abcd", g));
//		System.out.print(Recursion.min(g));
		double[] signal = {0, 1, 0, 2};
		double count;
		double[] newArray = new double[signal.length];
		for (int i = 0; i < signal.length; i++) {
			count = 0;
			for(int j = 0; j < signal.length; j++) {
				count += signal[j] * signal[(i+j) % signal.length];
				newArray[i] = count;

			}

		}
		System.out.print(newArray[2]);
	}

}
