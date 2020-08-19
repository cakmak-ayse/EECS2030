package labTest2;
/**
 * A class implementing an Animal
 * An animal should have a name and should be able to make a noise
 * @author 
 *
 */
public abstract class Animal {
	/**
	 * A final class which returns a noise representation for the animal
	 * @return a String object representing the noise an animal makes
	 */
	public final String getNoise(){		
		return gettheNoise();
	}
	//TODO more methods might be required

	public final String getName() {
		return gettheName();
	}

	public abstract String gettheNoise();
	public abstract String gettheName();


	
}
