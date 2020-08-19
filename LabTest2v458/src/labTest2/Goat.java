package labTest2;
/**
 * A class implementing  a Goat, a subclass of Animal
 * @author 
 *
 */
public class Goat extends Animal{
	private String name;
	private final String NOISE = "Baa";


	public Goat() {
		name = "";
	}
	public Goat(String name) {
		this.name = name;
	}

	
	@Override
	public String gettheNoise() {
		return this.NOISE;
	}
	
	@Override
	public String toString() {
		return "Goat " + name;
	}
	@Override
	public String gettheName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	
	
}
