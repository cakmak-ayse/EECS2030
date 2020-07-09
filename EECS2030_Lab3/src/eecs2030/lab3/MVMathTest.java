package eecs2030.lab3;

import static org.junit.Assert.*;

import org.junit.Test;

public class MVMathTest {

	@Test
	public void multiply_Matrix_Vector(){
		double[][] one = {{1d, 2d, 3d},
							{4d, 5d, 6d},
							{7d, 8d, 9d}};

		double[] two = {11d, 22d, 1d};

		double[] expected = {58d, 160d, 262d};
		
		Matrix3 m = new Matrix3(one);
		Vector3 v = new Vector3(two);
		double[] result = MVMath.multiply(m, v).getElements();
		
//		String error = String.format("Matrix and vector multiplication failed ");
//
//		for (int i = 0; i < expected.length; i++){
//				assertEquals(error, result[i], expected[i], 1e-6);
//		}
		assertEquals(expected, result);
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testMatrixMult() {
		double[][] one = {{1d, 2d, 3d},
				{4d, 5d, 6d},
				{7d, 8d, 9d}};

		double[][] two = {{11d, 12d},
				{21d, 22d}, 
				{31d, 32d}};

		double[][] expected = {{146d, 152d},
				{335d, 350d},
				{524d, 548d}};

		Matrix3 m1= new Matrix3 (one);
		Matrix3 m2= new Matrix3 (two);
		double [][] result = MVMath.multiply(m1, m2).getElements();

		String error = String.format("Matrix multiplication failed ");

		for (int i = 0; i < expected.length; i++){
			for (int j = 0; j < expected[0].length; j++){
				assertEquals(error, result[i][j], expected[i][j], 1e-6);
			}
		}
	}

	@Test
	public void testMatrixMult2() {
		double[][] one = {{1d, 2d, 3d},
				{4d, 5d, 6d}};

		Matrix3 m1= new Matrix3 (one);
		try {
			MVMath.multiply(m1, m1);
			String error = String.format("MVMath.multiply() failed to throw an exception");
			fail(error);
		} catch (IllegalArgumentException x) {
			// ok
		} catch (Exception x) {
			fail("wrong type of exception thrown");
		}
	}


}
