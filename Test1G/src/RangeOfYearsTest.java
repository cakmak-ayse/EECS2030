

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RangeOfYearsTest {

	@Test
	public void test01_noArgCtor() {
		RangeOfYears r = new RangeOfYears();
		// check min
		int exp = 0;
		int got = r.getMinimum();
		assertEquals(exp, got);

		// check max
		exp = 2020;
		got = r.getMaximum();
		assertEquals(exp, got);
	}

	@Test
	public void test02_ctor() {
		RangeOfYears r = new RangeOfYears(0, 2000);
		// check min
		int exp = 0;
		int got = r.getMinimum();
		assertEquals(exp, got);

		// check max
		exp = 2000;
		got = r.getMaximum();
		assertEquals(exp, got);
	}

	@Test
	public void test03_setMinimum() {
		RangeOfYears r = new RangeOfYears();
		r.setMinimum(1900);
		// check min
		int exp = 1900;
		int got = r.getMinimum();
		assertEquals(exp, got);
	}

	@Test
	public void test04_setMaximum() {
		RangeOfYears r = new RangeOfYears();
		r.setMaximum(2050);
		// check max
		int exp = 2050;
		int got = r.getMaximum();
		assertEquals(exp, got);
	}

	@Test
	public void test05_slice() {
		RangeOfYears r = new RangeOfYears(1900, 2020);
		r.slice(2000);
		// check min
		int exp = 2000;
		int got = r.getMinimum();
		assertEquals(exp, got);

		// check max
		exp = 2020;
		got = r.getMaximum();
		assertEquals(exp, got);
	}

	@Test
	public void test06_contains() {
		RangeOfYears r = new RangeOfYears(1900, 2020);
		assertTrue(r.contains(1950));
		assertFalse(r.contains(1000));
	}

	@Test
	public void test07_numberOfLeapYears() {
		RangeOfYears r = new RangeOfYears(1999, 2011);
		int exp = 3;
		int got = r.numberOfLeapYears();
		assertEquals(exp, got);
	}

	@Test
	public void test08_intersect() {
		RangeOfYears r = new RangeOfYears(2003, 2010);
		RangeOfYears s = new RangeOfYears(2008, 2012);
		
		RangeOfYears intersect = r.intersect(s);
		int exp = 2008;
		int got = intersect.getMinimum();
		assertEquals(exp, got);
		
		exp = 2010;
		got = intersect.getMaximum();
		assertEquals(exp, got);
	}


}
