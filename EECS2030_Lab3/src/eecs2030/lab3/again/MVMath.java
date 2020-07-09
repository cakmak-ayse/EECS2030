package eecs2030.lab3.again;

/**
 * A utility class containing some matrix/vector operations
 * @author Andriy
 * EECS 2030 Lab 3 SU2020
 */
public class MVMath {
	public MVMath (Matrix3 matrix) {
	}
	
	
	/**
	 * Multiplies a matrix by a vector. Note: the direct implementation would have been more efficient.
	 * @param m matrix
	 * @param v vector
	 * @return new vector object containing the result
	 */
	public static Vector3 multiply1 (Matrix3 m, Vector3 v){
		double [] vectorElements = v.getElements();
		double [][] matrixElements = m.getElements();
		if (matrixElements[0].length != vectorElements.length){
			throw new IllegalArgumentException();
		}
		//transpose the vector into a 1-column matrix
		double [][] oneColumnMatrix = new double [vectorElements.length][1];
		for (int i = 0; i < vectorElements.length; i++) oneColumnMatrix[i][0] = vectorElements[i];

		double [][] result = multiply2(m, new Matrix3(oneColumnMatrix)).getElements();

		//transpose the matrix result back into a vector by taking the left-most column
		double [] result1D = new double [result.length];
		for (int i = 0; i < result.length; i++) result1D[i] = result[i][0];
		return new Vector3(result1D);
	}

	/**
	 * @param m1 matrix 1
	 * @param m2 matrix 2
	 * @return new matrix object containing the result
	 */
	public static Matrix3 multiply2 (Matrix3 m1, Matrix3 m2){
		if (m1.getElements()[0].length != m2.getElements().length){
			throw new IllegalArgumentException();
		}
		double[][] result = new double[m1.getElements().length][m2.getElements()[0].length];
		 
	    for (int row = 0; row < result.length; row++) {
	        for (int col = 0; col < result[row].length; col++) {
	        	double sum = 0d;
	        	for (int i = 0; i < m2.getElements().length; i++){
	        		sum += m1.getElements()[row][i] * m2.getElements()  [i][col];
	        	}
	            result[row][col] = sum;
	        }
	    }
	    return new Matrix3(result);
	}
	
	/**
	 * Computes a cross product of two vectors
	 * @param v1 vector 1
	 * @param v2 vector 2
	 * @return a new vector object containing the result
	 */
	public static Vector3 crossProduct (Vector3 v1, Vector3 v2){
		double [] a = v1.getElements();
		double [] b = v2.getElements();

		return new Vector3(a[1] * b[2] - a[2] * b[1],
							- a[0] * b[2] + a[2] * b[0],
							a[0] * b[1] - a[1] * b[0]);
	}

	/**
	 * Computes a dot product of two vectors
	 * @param v1 vector 1
	 * @param v2 vector 2
	 * @return dot product (a scalar)
	 */
	public static double dotProduct (Vector3 v1, Vector3 v2){
		double [] a = v1.getElements();
		double [] b = v2.getElements();
		return a[0] * b[0] + a[1] * b[1] + a[2] * b[2];
	}

}
