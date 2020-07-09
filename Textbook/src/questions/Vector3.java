package questions;

public class Vector3 {

	/**
	 * Creates a 3D vector from an array
	 * @param v array containing 3 components of the desired vector 
	 */
	private double x, y, z;
	private double[] vector;
	
	public Vector3(double[] v) {
		this(v[0], v[1], v[2]);
		this.vector = v;
	}

	/**
	 * Creates a 3D vector from 3 numeric scalar components
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param z z coordinate
	 */
	public Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;	
	}

	/**
	 * Clones an existing vector
	 * @param old an existing Vector3 object 
	 */
	public Vector3(Vector3 old) {
		this(old.x, old.y, old.z);
	}

	/**
	 * Returns a vector component at a specified index
	 * @param index the index of the vector component
	 * @return vector component as a scalar
	 */
	public double getElement (int index){
		return vector[index];
	}

	/**
	 * Returns vector components as an array
	 * @return
	 */
	public double[] getElements (){
		double[] vector = {this.x, this.y, this.z};
		return vector;
	}

	public static void main(String[] args) {
		double test [] = {1.0, 2.0, 3.0};
		Vector3 vec = new Vector3(test);
		System.out.print(vec.getElements());
	}

}
