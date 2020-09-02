package eecs2030.lab3;

/**
 * A utility class containing some matrix/vector operations
 * @author Andriy
 * EECS 2030 Lab 3 SU2020
 */
public class MVMath {
	Matrix3 mat;
	public MVMath (Matrix3 matrix) {
		this.mat = new Matrix3(matrix);	
	}
	
	
	/**
	 * Multiplies a matrix by a vector
	 * @param m matrix
	 * @param v vector
	 * @return new vector object containing the result
	 */
	public static Vector3 multiply (Matrix3 m, Vector3 v){
		Matrix3 matrix = new Matrix3(m);	
		double row1Col1 = matrix.getElements()[0][0];
		double row1Col2 = matrix.getElements()[0][1];
		double row1Col3 = matrix.getElements()[0][2];
		
		double row2Col1 = matrix.getElements()[1][0];
		double row2Col2 = matrix.getElements()[1][1];
		double row2Col3 = matrix.getElements()[1][2];
		
		double row3Col1 = matrix.getElements()[2][0];
		double row3Col2 = matrix.getElements()[2][1];
		double row3Col3 = matrix.getElements()[2][2];
		
		
		
		Vector3 vec = new Vector3(v);
		double vector1 = vec.getElements()[0];
		double vector2 = vec.getElements()[1];
		double vector3 = vec.getElements()[2];
		
		
		double row1 = (row1Col1 * vector1) + (row1Col2 * vector2) + (row1Col3 * vector3);
		double row2 = (row2Col1 * vector1) + (row2Col2 * vector2) + (row2Col3 * vector3);
		double row3 = (row3Col1 * vector1) + (row3Col2 * vector2) + (row3Col3 * vector3);
		
		
		double[] vector = {row1, row2, row3};
		Vector3 result = new Vector3(vector);
		return result;
	}


	
	
	/**
	 * @param m1 matrix 1
	 * @param m2 matrix 2
	 * @return new matrix object containing the result
	 */
	public static Matrix3 multiply (Matrix3 m1, Matrix3 m2){
	    if (m1.getElements()[0].length == m2.getElements().length) {
	    	double firstRow1Col1 = m1.getElements()[0][0];
			double firstRow1Col2 = m1.getElements()[0][1];
			
			double firstRow2Col1 = m1.getElements()[1][0];
			double firstRow2Col2 = m1.getElements()[1][1];
			
			double firstRow3Col1 = m1.getElements()[2][0];
			double firstRow3Col2 = m1.getElements()[2][1];
			
			
			
			double secondRow1Col1 = m2.getElements()[0][0];
			double secondRow1Col2 = m2.getElements()[0][1];
			
			double secondRow2Col1 = m2.getElements()[1][0];
			double secondRow2Col2 = m2.getElements()[1][1];
			
			double secondRow3Col1 = m2.getElements()[2][0];
			double secondRow3Col2 = m2.getElements()[2][1];
			
	    	
	    	
	    	double row1Col1 = (firstRow1Col1 * secondRow1Col1) + (firstRow1Col2 * secondRow2Col1);
	    	double row1Col2 = (firstRow1Col1 * secondRow1Col2) + (firstRow1Col2 * secondRow2Col2);
	    	
	    	double row2Col1 = (firstRow2Col1 * secondRow1Col1) + (firstRow2Col2 * secondRow2Col1);
	    	double row2Col2 = (firstRow2Col1 * secondRow1Col2) + (firstRow2Col2 * secondRow2Col2);
	    	
	    	double row3Col1 = (firstRow3Col1 * secondRow1Col1) + (firstRow3Col2 * secondRow2Col1);
	    	double row3Col2 = (firstRow3Col1 * secondRow1Col2) + (firstRow3Col2 * secondRow2Col2);
	    	
	    	
	    	if (m1.getElements()[0].length == 3 && m2.getElements()[0].length == 3) {
	    		
	    		double firstRow1Col3 = m1.getElements()[0][2];
	    		double firstRow2Col3 = m1.getElements()[1][2];
	    		double firstRow3Col3 = m1.getElements()[2][2];
	    		
	    		
	    		double secondRow1Col3 = m2.getElements()[0][2];
	    		double secondRow2Col3 = m2.getElements()[1][2];
	    		double secondRow3Col3 = m2.getElements()[2][2];
	    		
	    		
	    		
	    		row1Col1 = (firstRow1Col1 * secondRow1Col1) + (firstRow1Col2 * secondRow2Col1) + (firstRow1Col3 * secondRow3Col1);
		    	row1Col2 = (firstRow1Col1 * secondRow1Col2) + (firstRow1Col2 * secondRow2Col2) + (firstRow1Col3 * secondRow3Col2);
		    	double row1Col3 = (firstRow1Col1 * secondRow1Col3) + (firstRow1Col2 * secondRow2Col3) + (firstRow1Col3 * secondRow3Col3);
		    	
		    	row2Col1 = (firstRow2Col1 * secondRow1Col1) + (firstRow2Col2 * secondRow2Col1) + (firstRow2Col3 * secondRow3Col1);
		    	row2Col2 = (firstRow2Col1 * secondRow1Col2) + (firstRow2Col2 * secondRow2Col2) + (firstRow2Col3 * secondRow3Col2);
		    	double row2Col3 = (firstRow2Col1 * secondRow1Col3) + (firstRow2Col2 * secondRow2Col3) + (firstRow2Col3 * secondRow3Col3);
		    	
		    	row3Col1 = (firstRow3Col1 * secondRow1Col1) + (firstRow3Col2 * secondRow2Col1) + (firstRow3Col3 * secondRow3Col1);
		    	row3Col2 = (firstRow3Col1 * secondRow1Col2) + (firstRow3Col2 * secondRow2Col2) + (firstRow3Col3 * secondRow3Col2);
		    	double row3Col3 = (firstRow3Col1 * secondRow1Col3) + (firstRow3Col2 * secondRow2Col3) + (firstRow3Col3 * secondRow3Col3);
	    		
		    	
		    	
		    	double[][] array = {{row1Col1, row1Col2, row1Col3}, 
						{row2Col1, row2Col2, row2Col3}, 
						{row3Col1, row3Col2, row3Col3}};
		    	Matrix3 result = new Matrix3(array);
		    	return result;	
	    	}
	    	
	    	double[][] array = {{row1Col1, row1Col2}, 
	    						{row2Col1, row2Col2}, 
	    						{row3Col1, row3Col2}};
	    	Matrix3 result = new Matrix3(array);
	    	return result;	
	    } 
	    else throw new IllegalArgumentException();
	
	}
	
	
	/**
	 * Computes a cross product of two vectors
	 * @param v1 vector 1
	 * @param v2 vector 2
	 * @return a new vector object containing the result
	 */
	public static Vector3 crossProduct (Vector3 v1, Vector3 v2){
		double firstVectori = v1.getElement(0);
		double firstVectorj = v1.getElement(1);
		double firstVectork = v1.getElement(2);
		
		double secondVectori = v2.getElement(0);
		double secondVectorj = v2.getElement(1);
		double secondVectork = v2.getElement(2);
		
		double i = (firstVectorj * secondVectork) - (firstVectork * secondVectorj);
		double j = (firstVectork * secondVectori) - (firstVectori * secondVectork);
		double k = (firstVectori * secondVectorj) - (firstVectorj * secondVectori);
		
		double[] vector = {i, j, k};
		Vector3 result = new Vector3(vector);
		return result;
	}

	/**
	 * Computes a dot product of two vectors
	 * @param v1 vector 1
	 * @param v2 vector 2
	 * @return dot product (a scalar)
	 */
	public static double dotProduct (Vector3 v1, Vector3 v2){
		double multplyFirst = v1.getElement(0) * v2.getElement(0);
		double multplySecond = v1.getElement(1) * v2.getElement(1);
		double multplyThird = v1.getElement(2) * v2.getElement(2);
		
		double result = multplyFirst + multplySecond + multplyThird;
		return result;
	}

}
