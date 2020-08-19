package labTest2;

import java.util.ArrayList;
import java.util.List;

public class AnimalClassesTester {
	public static void main(String[] args) {
		//Animal animal = new Animal (); //should be impossible 
		Goat goat1 = new Goat();
		System.out.println("[Testing anon Goat]\n" + goat1);

		Animal goat2 = new Goat("Muriel"); 
		System.out.println("[Testing Goat Muriel toString]\n" + goat2);
		System.out.println("[Testing Goat getName]\n" + goat2.getName());
		//String name = goat2.name; //should be impossible 
		System.out.println("[Testing Goat noise]\n" + goat2.getNoise());

		Animal horse = new Horse("Benjamin"); 
		System.out.println("[Testing Horse Benjamin]\n" + horse);
		System.out.println("[Testing Horse noise]\n" + horse.getNoise());

		Animal pig = new Pig("Squealer"); 
		System.out.println("[Testing Pig Squealer]\n" + pig);
		System.out.println("[Testing Pig noise]\n" + pig.getNoise());
		
		List <Animal> list = new ArrayList<>();
		list.add(goat1);
		list.add(goat2);
		list.add(horse);
		list.add(pig);
		
		System.out.println("[Testing Animal list + Animals' toString]");
		System.out.println(list);

		AnimalFarm farm = new AnimalFarm(list);
		System.out.println("[Testing Animal farm toString]");
		System.out.println(farm);
		System.out.println(farm.getAnimals()==(list)); //should be false
		System.out.println(farm.getAnimals().equals(list)); //should be true
		System.out.println(farm.animalCounts());
		
		List <Goat> list2 = new ArrayList<>();
		list2.add(goat1);
//		AnimalFarm farm2 = new AnimalFarm(list2);
//		System.out.println(farm2);
//		System.out.println(farm2.animalCounts());

		AnimalFarm farm3 = new AnimalFarm();
		System.out.println(farm3);
		System.out.println(farm3.animalCounts());
	}
}
