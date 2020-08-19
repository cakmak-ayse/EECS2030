package practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayLists {
	public List<String> addColours(List<String> colours) {
		List<String> listOfColours = new ArrayList<String>();
		listOfColours.addAll(colours);
		
		return listOfColours;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayLists test = new ArrayLists();
		List<String> list = new ArrayList<>();
		list.add("blue");
		list.add("red");
		list.add("white");
		
		System.out.println(test.addColours(list));
		
	}

}
