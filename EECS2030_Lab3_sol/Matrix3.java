package eecs2030.lab3;

import java.util.Arrays;

/**
 * An immutable class implementing a 3x3 matrix 
 * @author Andriy
 * EECS 2030 Lab 3 SU2020
 */
public class Matrix3 {
	private final double [][] m;

	/**
	 * Creates a 3x3 matrix from an 2D array
	 * @param array array containing the elements of the desired matrix	 
	 */
	public Matrix3(double[][] array) {
		this.m = new double [array.length][];
		for (int i = 0; i < array.length; i++) {
			this.m[i] = Arrays.copyOf(array[i], array[i].length);
		}	
	}
	
	/**
	 * Clones an existing matrix
	 * @param old an existing Matrix3 object 
	 */
	public Matrix3(Matrix3 old) {
		this.m = new double [old.m.length][];
		for (int i = 0; i < old.m.length; i++) {
			this.m[i] = Arrays.copyOf(old.m[i], old.m[i].length);
		}	
	}

	/**
	 * Returns a matrix element at a row, column
	 * @param row row
	 * @param column column
	 * @return matrix element as a scalar
	 */
	public double getElement (int row, int column){
		return m[row][column];
	}
	
	/**
	 * Returns matrix elements as a 2D array
	 * @return 2D array containing matrix elements
	 */
	public double[][] getElements (){
		double [][] result = new double [this.m.length][];
		for (int i = 0; i < this.m.length; i++) {
			result[i] = Arrays.copyOf(this.m[i], this.m[i].length);
		}	
		return result;
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Matrix\n");
		for (int i = 0; i < m.length; i++){
			for (int j = 0; j < m[0].length; j++){
				sb.append(m[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
