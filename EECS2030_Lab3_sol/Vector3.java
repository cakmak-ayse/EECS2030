package eecs2030.lab3;

import java.util.Arrays;

/**
 * An immutable class implementing a 3D vector 
 * @author Andriy
 * EECS 2030 Lab 3 SU2020
 *
 */
public class Vector3 implements Comparable <Vector3>{
	private double [] v;

	/**
	 * Creates a 3D vector from an array
	 * @param v array containing 3 components of the desired vector 
	 */
	public Vector3(double[] v) {
		//this.v = v;
		this.v = Arrays.copyOf(v, v.length);
	}

	/**
	 * Creates a 3D vector from 3 numeric scalar components
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param z z coordinate
	 */
	public Vector3(double x, double y, double z) {
		this.v = new double [3];
		this.v[0] = x;
		this.v[1] = y;
		this.v[2] = z;
	}

	/**
	 * Clones an existing vector
	 * @param old an existing Vector3 object 
	 */
	public Vector3(Vector3 old) {
		this(old.v);
	}

	/**
	 * Returns a vector component at a specified index
	 * @param index the index of the vector component
	 * @return vector component as a scalar
	 */
	public double getElement (int index){
		return v[index];
	}

	/**
	 * Returns vector components as an array
	 * @return
	 */
	public double[] getElements (){
		return Arrays.copyOf(this.v, this.v.length);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(v);
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
		if (!Arrays.equals(v, other.v))
			return false;
		return true;
	}

	@Override
	public int compareTo(Vector3 o) {
		double thisM2 = v[0] * v[0] + v[1] * v[1] + v[2] * v[2];
		double otherM2 = o.v[0] * o.v[0] + o.v[1] * o.v[1] + o.v[2] * o.v[2];
		if (thisM2 > otherM2) return 1;
		if (thisM2 < otherM2) return -1;
		return 0;
	}

	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Vector\n");
		for (int i = 0; i < v.length; i++){
			sb.append(v[i]);
			sb.append(" ");
		}
		return sb.toString();
	}

	
}
