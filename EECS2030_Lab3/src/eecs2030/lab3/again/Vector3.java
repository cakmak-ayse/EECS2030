package eecs2030.lab3.again;

import java.util.Arrays;

/**
 * An immutable class implementing a 3D vector 
 * @author Andriy
 * EECS 2030 Lab 3 SU2020
 *
 */
public class Vector3 implements Comparable <Vector3>{

	private double x, y, z;
	private double[] vector;
	
	/**
	 * Creates a 3D vector from an array
	 * @param v array containing 3 components of the desired vector 
	 */
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(vector);
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector3 other = (Vector3) obj;
		if (!Arrays.equals(vector, other.vector))
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}
	
	
	@Override
	public int compareTo(Vector3 o) {
		double thisDist= Math.sqrt((x * x) + (y * y) + (z * z));
		double otherDist= Math.sqrt((o.x * o.x) + (o.y * o.y) + (o.z * o.z));
		
		if(thisDist > otherDist) return 1;
		else if (thisDist < otherDist) return -1;
		return 0;
	}
	
	
	
	
	
}
