package labTest2;
/**
 * A class implementing a Pig, a subclass of Animal
 * @author 
 *
 */
public class Pig extends Animal {
	private String name;
	private final String NOISE = "Oink-oink";

	
	public Pig(String name) {
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
		return "Pig " + name;
	}
}
