import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Range2Test {

	@Test
	public void test1_noArgCtor() {
		Range2 r = new Range2();
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
	public void test2_ctor() {
		Range2 r = new Range2(-100, 200);
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
	public void test3_setMinimum() {
		Range2 r = new Range2();
		r.setMinimum(-10);
		// check min
		int exp = -10;
		int got = r.getMinimum();
		assertEquals(exp, got);
	}

	@Test
	public void test4_setMaximum() {
		Range2 r = new Range2();
		r.setMaximum(10);
		// check min
		int exp = 10;
		int got = r.getMaximum();
		assertEquals(exp, got);
	}

	@Test
	public void test5_slice() {
		Range2 r = new Range2(-100, 200);
		r.slice(50);
		// check min
		int exp = -100;
		int got = r.getMinimum();
		assertEquals(exp, got);

		// check max
		exp = 50;
		got = r.getMaximum();
		assertEquals(exp, got);
	}

	@Test
	public void test6_contains() {
		Range2 r = new Range2(-100, 200);
		assertTrue(r.contains(0));
		assertFalse(r.contains(1000));
	}

	@Test
	public void test7_contains() {
		Range2 r = new Range2(-100, 200);
		assertTrue(r.contains(new Range2(0, 50)));
		assertFalse(r.contains(new Range2(150, 300)));
	}

	@Test
	public void test8_removeAll() {
		Range2 r = new Range2(-100, 200);
		r.removeAll(new Range2(50, 300));
		// check min
		int exp = -100;
		int got = r.getMinimum();
		assertEquals(exp, got);

		// check max
		exp = 49;
		got = r.getMaximum();
		assertEquals(exp, got);
	}

	@Test
	public void testToString() {
		Range2 r = new Range2(-100, 200);
		String exp = "[-100, 200]";
		String got = r.toString();
		assertEquals(exp, got);
	}

}
