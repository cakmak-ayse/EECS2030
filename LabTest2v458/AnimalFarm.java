package labTest2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eecs2030.lab6.Card;

/**
 * The class implements an animal farm. Any object 
 * which is an Animal can be stored inside
 * @author 
 *
 */
public class AnimalFarm {
	//TODO some fields might be needed
	List<Animal> farm; 
	List <Goat> goat;
	
	/**
	 * Creates an empty farm
	 */
	public AnimalFarm() {
		this.farm = new ArrayList<>();
	}

	
	/**
	 * Creates a farm with the specified animals
	 * @param animals
	 * 				a collection of animals
	 */
	public AnimalFarm(List animals) { //you might need to modify the parameter type here
		this.farm = animals;
//		this.hand = new ArrayList<Card>();
//		for(Card c : hand) {
//			this.hand.add(c);
//		}
	}


//	public AnimalFarm(List<Goat> name) {
//		this.goat = name;
//	}


	public AnimalFarm(List<Goat> goat) {
		this.goat = goat;
	}



	/**
	 * Returns a list of animals on the form. The reference returned
	 * should not allow one to  modify any data inside this object
	 * @return a list of all the animals on the farm  
	 */
	@SuppressWarnings("unchecked")
	public List<Animal> getAnimals(){ //you might need to modify this line
		List<Animal> animal = new ArrayList<Animal>();
		for(Animal a : this.farm) {
			animal.add(a);
		}
		return animal;
	}
	
	/**
	 * Returns a map containing the counts for all the animal types
	 * present on the  farm (e.g., 10 horses, 7 pigs, 52 goats...)
	 * @return map containing the counts for all the animal types
	 */
	public Map<Animal, Integer> animalCounts(){ //you might need to modify this line
		Map<Animal, Integer> map = new HashMap<>();
		
		
	}

	/**
	 * @param animal
	 * 				an animal to add to the farm
	 */
	public void addAnimal (Animal animal){
		//no need to implement this method
	}
	
	/**
	 * @param animal
	 * 				an animal to remove from the farm
	 */
	public void removeAnimal (Animal animal){
		//no need to implement this method
	}
	
	//TODO more methods might be required
}
