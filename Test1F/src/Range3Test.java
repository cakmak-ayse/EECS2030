
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Range3Test {

	@Test
	public void test01_noArgCtor() {
		Range3 r = new Range3();
		// check min
		int exp = -1;
		int got = r.getMinimum();
		assertEquals(exp, got);

		// check max
		exp = 1;
		got = r.getMaximum();
		assertEquals(exp, got);
	}

	@Test
	public void test02_ctor() { 
		Range3 r = new Range3(-100, 200);
		// check min
		int exp = -100;
		int got = r.getMinimum();
		assertEquals(exp, got);

		// check max
		exp = 200;
		got = r.getMaximum();
		assertEquals(exp, got);
	}

	@Test
	public void test03_expandLeft() {
		Range3 r = new Range3();
		r.expandLeft();
		// check min
		int exp = -2;
		int got = r.getMinimum();
		assertEquals(exp, got);
	}

	@Test
	public void test04_expandRight() {
		Range3 r = new Range3();
		r.expandRight(10);
		// check max
		int exp = 11;
		int got = r.getMaximum();
		assertEquals(exp, got);
	}

	@Test
	public void test05_contains() {
		Range3 r = new Range3(-100, 200);
		assertTrue(r.contains(0));
		assertFalse(r.contains(1000));
	}

	@Test
	public void test6_compareTo() {
		Range3 r = new Range3(-100, 200);
		Range3 s = new Range3(0, 2);
		assertTrue(r.compareTo(s) > 0);
		assertTrue(r.compareTo(r) == 0);
		assertTrue(s.compareTo(r) < 0);
	}

	@Test
	public void test07_fizzBuzz() {
		Range3 r = new Range3(10, 15);
		
		// check result
		String exp = "buzz, 11, fizz, 13, 14, fizzbuzz";
		String got = r.fizzBuzz();
		assertEquals(exp, got);
	}

	@Test
	public void testToString() {
		Range3 r = new Range3(-100, 200);
		String exp = "[-100, 200]";
		String got = r.toString();
		assertEquals(exp, got);
	}

}
