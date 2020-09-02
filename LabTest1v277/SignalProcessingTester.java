package labTest1;

import static org.junit.Assert.*;

import java.util.Arrays;
//import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignalProcessingTester {
	@Test
	public void testAutoCorrelation() {
		double[] signal = {0, 1, 0, 2};
		double[] expected = {5, 0, 4, 0};
		double[] result = SignalProcessing.autoCorrelation(signal);

		String error = String.format("SignalProcessing.autoCorrelation() failed");
		assertTrue(error, Arrays.equals(result, expected));
	}

	@Test
	public void testRMS() {
		double[] signal = {0, 1, 0, 2};
		String error = String.format("SignalProcessing.rms() failed");
		assertEquals(error, 5.0/4.0, Math.pow(SignalProcessing.rms(signal), 2), 1e-6);
	}
	


}
