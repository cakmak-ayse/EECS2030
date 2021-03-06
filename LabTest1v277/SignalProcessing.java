package labTest1;
/** This class is expected to contain methods for signal processing
 * @author Andriy
 * TODO complete the implementation of the class (constructors, methods...)
 */
public class SignalProcessing {
	
	/**
	 * @param signal  input signal
	 * @return an array containing the result of the signal being correlated with with a delayed copy of itself 
	 * E.g., an array {0, 1, 0, 2} will result in: 
	 * {0, 1, 0, 2}
	 * {0, 1, 0, 2} - delay of zero
	 * 0*0 + 1*1 + 0*0 + 2*2 = 5 for the 0-th element of the array
	 * 
	 * {0, 1, 0, 2}
	 * {1, 0, 2, 0} -  delay of one
	 * 0 for the 1st element
	 * 
	 * {0, 1, 0, 2}
	 * {0, 2, 0, 1} - delay of two
	 * 1*2 + 2*1 = 4 for the 2nd element
	 * 
	 * and 0 for the 3rd element (similar to delay of 1)
	 * 
	 * Thus, the returned array will be {5, 0, 4, 0}
	 * Side note: the 4 in the 2nd position of output array 
	 * indicates that a portion of the signal repeats itself 
	 * with a delay of 2 time units
	 * 
	 */
	public static double [] autoCorrelation (double [] signal){
		//Start of  the solution (do not remove this line)
		double count;
		double[] newArray = new double[signal.length];
		for (int i = 0; i < signal.length; i++) {
			count = 0;
			for(int j = 0; j < signal.length; j++) {
				count += signal[j] * signal[(i+j) % signal.length];
				newArray[i] = count;
			}		
		}
				return newArray;
		
		//end  of the  solution (do not remove this line)
	}

	/**
	 * @param signal input
	 * @return the RMS of the signal
	 * RMS is  defined as the square root of the mean square 
	 * (the  arithmetic mean of the squares of a set of numbers)
	 * E.g., for {0, 1, 0, 2} the RMS is sqrt[(1*1 + 2*2)/4) - approx. 1.12
	 */
	public static double rms(double [] signal){
		//Start of the solution (do not remove this line)
		double count = 0;
		for (int i = 0; i < signal.length; i++) {
			count += signal[i] * signal[i];
		}
		double mean = count / signal.length;
		
		double result = Math.sqrt(mean);
		return result;
		
		//end of the solution (do not remove this line)
	}

}
