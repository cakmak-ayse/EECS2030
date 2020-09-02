import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChessSquareTest {

	@Test
	public void test01_noArgCtor() {
		ChessSquare q = new ChessSquare();
		// check file
		String exp = "a";
		String got = q.file();
		assertEquals(exp, got);
		
		// check rank
		exp = "1";
		got = q.rank();
		assertEquals(exp, got);
		
		// check piece
		exp = "";
		got = q.piece();
		assertEquals(exp, got);
	}

	@Test
	public void test02_ctor() {
		ChessSquare q = new ChessSquare("c", "4", "Q");
		// check file
		String exp = "c";
		String got = q.file();
		assertEquals(exp, got);
		
		// check rank
		exp = "4";
		got = q.rank();
		assertEquals(exp, got);
		
		// check piece
		exp = "Q";
		got = q.piece();
		assertEquals(exp, got);
	}

	@Test
	public void test03_copyCtor() {
		ChessSquare orig = new ChessSquare("c", "4", "Q");
		ChessSquare q = new ChessSquare(orig);
		// check file
		String exp = "c";
		String got = q.file();
		assertEquals(exp, got);
		
		// check rank
		exp = "4";
		got = q.rank();
		assertEquals(exp, got);
		
		// check piece
		exp = "Q";
		got = q.piece();
		assertEquals(exp, got);
	}

	@Test
	public void test04_isAdjacentTo() {
		ChessSquare q = new ChessSquare("c", "4", "Q");
		ChessSquare r = new ChessSquare("d", "5", "");
		assertTrue(q.isAdjacentTo(r));
	}

	@Test
	public void test05_areConnected() {
		ChessSquare q = new ChessSquare("c", "4", "Q");
		ChessSquare r = new ChessSquare("c", "8", "");
		assertTrue(q.areConnected(r));
		
		r = new ChessSquare("e", "8", "");
		assertFalse(q.areConnected(r));
	}

	@Test
	public void test06_equals() {
		ChessSquare q = new ChessSquare("c", "4", "Q");
		ChessSquare r = new ChessSquare("c", "4", "");
		assertTrue(q.equals(r));
		
		r = new ChessSquare("g", "2", "Q");
		assertFalse(q.equals(r));
	}

	@Test
	public void testHashCode() {
		ChessSquare q = new ChessSquare("c", "4", "Q");
		ChessSquare r = new ChessSquare("c", "8", "");
		assertNotEquals(q.hashCode(), r.hashCode());
	}


}
