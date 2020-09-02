package questions;

public class Matrix3 {

	final private double[][] matrix;
	

	/**
	 * Creates a 3x3 matrix from an 2D array
	 * @param v array containing 3 components of the desired vector 
	 */	
	public Matrix3(double[][] array) {
		double[][] matr = array;
		this.matrix = new double[matr.length][matr[0].length];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				this.matrix[i][j] = matr[i][j];
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
	public double getElement (int row, int column){
		return matrix[row][column];
	}
	
	/**
	 * Returns matrix elements as a 2D array
	 * @return 2D array containing matrix elements
	 */
	public double[][] getElements (){
		return matrix;
	}

	
	public static void main(String[] args) {
		double[][] matrix = {{1.0, 2.0},
				  			{4.0, 5.0},
				  			{7.0, 8.0}};
		Matrix3 test = new Matrix3(matrix);
		System.out.print(test.getElements()[0].length);
		
	}
	
}
