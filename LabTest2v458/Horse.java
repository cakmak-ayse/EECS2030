package labTest2;
/**
 * A class implementing a Horse, a subclass of Animal
 * @author 
 *
 */
public class Horse extends Animal{
	private String name;
	private final String NOISE = "Neigh";


	public Horse(String name) {
		this.name = name;
	}

	@Override
	public String gettheNoise() {
		return this.NOISE;
	}
	@Override
	public String gettheName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	@Override
	public String toString() {
		return "Horse " + name;
	}
}
