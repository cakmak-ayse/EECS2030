package eecs2030.lab3.again;

//import java.util.Arrays;

/**
 * An immutable class implementing a 3x3 matrix 
 * @author Andriy
 * EECS 2030 Lab 3 SU2020
 */
public class Matrix3 {

	final private double[][] matrix;
	

	/**
	 * Creates a 3x3 matrix from an 2D array
	 * @param @param array array containing the elements of the desired matrix
	 */	
	public Matrix3(double[][] array) {
		double[][] matr = array;
		this.matrix = new double[matr.length][matr[0].length];

		for (int row = 0; row < matr.length; row++ ) {
			for (int col = 0; col < matr[row].length; col++) {
				this.matrix[row][col] = matr[row][col];
			}
		}
		
	}
	
	/**
	 * Clones an existing matrix
	 * @param old an existing Matrix3 object 
	 */
	public Matrix3(Matrix3 old) {
		this(old.matrix);
	}

	/**
	 * Returns a matrix element at a row, column
	 * @param row row
	 * @param column column
	 * @return matrix element as a scalar
	 */
	public double getElement(int row, int column){
		return this.matrix[row][column];
	}
	
	/**
	 * Returns matrix elements as a 2D array
	 * @return 2D array containing matrix elements
	 */
	public double[][] getElements (){
		return this.matrix;
	}

}
