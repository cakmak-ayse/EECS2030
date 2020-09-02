package questions;

public class Pg17_226 {


	public static long factorial(int n) {
		long count = 1L;
		for(long i = 1L; i <= n; i++) {
			count =  i*count;
		}
		return count;
	}
	
	public double getElement (int row, int column){
		double[][] matr = {{3, 4, 8, 2}, 
							{9, 5, 3, 0},
							{2, 4, 7, 8}};
		double result = 0;
		for (int i = 0; i < matr.length; i++) {			
				for (int j = 0; j < matr[i].length; j++) {
					if (matr[i][j] == matr[row][column]) {
						System.out.println(matr[row][column]);	
					}
				}
		}
		return result;
	}

	public static void main(String[] args) {
//		System.out.print(Pg17_226.factorial(6));
//		Pg17_226 ss = new Pg17_226();
//		System.out.print(ss.getElement(1, 3));
	
 
		double[][] matr = {{3, 4, 8, 2}, 
				{9, 5, 3, 0},
				{2, 4, 7, 8}};
		System.out.println(matr[1][3]);
		for (int i = 0; i < matr.length; i++) {
//			System.out.println(i);			
			for (int j = 0; j < matr[i].length; j++) {
//				System.out.println(row);
//				if (matr[i][j] == matr[row][column]) {
					System.out.println(matr[1][3]);	
//				}
			}
		}
	}
}
