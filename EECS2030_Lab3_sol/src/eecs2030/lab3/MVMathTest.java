package eecs2030.lab3;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.junit.Test;

public class MVMathTest {

	@Test
	public void testMVMathConstructor() {
		final Constructor<?>[] constructors = MVMath.class.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			assertTrue("MVMath contains a public constructor", Modifier.isPrivate(constructor.getModifiers()));
		}
	}

	@Test
	public void testCrossProduct() {
		double[] vector1 = {1d, 2d, 3d};
		double[] vector2 = {4d, 5d, 6d};
		double[] expected = {-3d, 6d, -3d};
		double[] result = MVMath.crossProduct(new Vector3(vector1), new Vector3(vector2)).getElements();
		String error = String.format("MVMath.crossProduct() failed");
		assertTrue(error, Arrays.equals(result, expected));
	}

	@Test
	public void testDotProduct() {
		double[] vector1 = {1d, 2d, 3d};
		double[] vector2 = {4d, 5d, 6d};
		double expected = 32.0;
		double actual = MVMath.dotProduct(new Vector3(vector1), new Vector3(vector2));
		String error = String.format("MVMath.dotProduct() failed");
		assertEquals(error, expected, actual, 1e-6);
	}

	
	@Test
	public void testVectorMatrixMult() {
		double[][] matrix = {{1d, 2d, 3d},
				{4d, 5d, 6d},
				{7d, 8d, 9d}};

		double[] vector = {1d, 2d, 3d};

		double[] expected = {14d, 32d, 50d};

		Vector3 v = new Vector3 (vector);
		Matrix3 m = new Matrix3 (matrix);
		double [] result = MVMath.multiply(m, v).getElements();

		String error = String.format("Vector-Matrix multiplication failed ");

		for (int i = 0; i < expected.length; i++){
			assertEquals(error, result[i], expected[i], 1e-6);
		}
		
		try {
			MVMath.multiply(m, new Vector3(new double [2]));
			 error = String.format("MVMath.multiply(m, v) failed to throw an exception");
			fail(error);
		} catch (IllegalArgumentException x) {
			// ok
		} catch (Exception x) {
			fail("wrong type of exception thrown");
		}

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
			String error = String.format("MVMath.multiply(m, m) failed to throw an exception");
			fail(error);
		} catch (IllegalArgumentException x) {
			// ok
		} catch (Exception x) {
			fail("wrong type of exception thrown");
		}
	}


}
