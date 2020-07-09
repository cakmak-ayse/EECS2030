import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TimeOfDayTest {

	@Test
	public void test01_noArgCtor() {
		TimeOfDay t = new TimeOfDay();
		// check hour
		int exp = 12;
		int got = t.getHour();
		assertEquals(exp, got);
		
		// check minute
		exp = 0;
		got = t.getMinute();
		assertEquals(exp, got);
		
		// check AM/PM
		assertTrue(t.isAM());
	}

	@Test
	public void test02_ctor() {
		TimeOfDay t = new TimeOfDay(7, 25, false);
		// check hour
		int exp = 7;
		int got = t.getHour();
		assertEquals(exp, got);
		
		// check minute
		exp = 25;
		got = t.getMinute();
		assertEquals(exp, got);
		
		// check AM/PM
		assertFalse(t.isAM());
	}

	@Test
	public void test03_copyCtor() {
		TimeOfDay orig = new TimeOfDay(7, 25, false);
		TimeOfDay t = new TimeOfDay(orig);
		// check hour
		int exp = 7;
		int got = t.getHour();
		assertEquals(exp, got);
		
		// check minute
		exp = 25;
		got = t.getMinute();
		assertEquals(exp, got);
		
		// check AM/PM
		assertFalse(t.isAM());
	}

	@Test
	public void test04_setHour() {
		TimeOfDay t = new TimeOfDay();
		t.setHour(11);
		// check hour
		int exp = 11;
		int got = t.getHour();
		assertEquals(exp, got);
		
		// check minute
		exp = 0;
		got = t.getMinute();
		assertEquals(exp, got);
		
		// check AM/PM
		assertTrue(t.isAM());
	}

	@Test
	public void test05_setMinute() {
		TimeOfDay t = new TimeOfDay();
		t.setMinute(45);
		// check hour
		int exp = 12;
		int got = t.getHour();
		assertEquals(exp, got);
		
		// check minute
		exp = 45;
		got = t.getMinute();
		assertEquals(exp, got);
		
		// check AM/PM
		assertTrue(t.isAM());
	}

	@Test
	public void test06_isAM() {
		TimeOfDay t = new TimeOfDay();
		assertTrue(t.isAM());
		
		t = new TimeOfDay(12, 1, false);
		assertFalse(t.isAM());
	}

	@Test
	public void test07_advance() {
		TimeOfDay t = new TimeOfDay();
		t.advance(3);
		// check hour
		int exp = 12;
		int got = t.getHour();
		assertEquals(exp, got);
		
		// check minute
		exp = 3;
		got = t.getMinute();
		assertEquals(exp, got);
		
		// check AM/PM
		assertTrue(t.isAM());
	}
	
	@Test
	public void test08_advanceMinus() {
		TimeOfDay t = new TimeOfDay(8, 30, false);
		t.advance(-3);
		// check hour
		int exp = 8;
		int got = t.getHour();
		assertEquals(exp, got);
		
		// check minute
		exp = 27;
		got = t.getMinute();
		assertEquals(exp, got);
		
		// check AM/PM
		assertFalse(t.isAM());
	}

	@Test
	public void test09_toString() {
		TimeOfDay t = new TimeOfDay();
		String exp = "12:00 AM";
		String got = t.toString();
		assertEquals(exp, got);
	}

}
