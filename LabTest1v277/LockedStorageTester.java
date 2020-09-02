package labTest1;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

//import java.util.Arrays;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LockedStorageTester {
	@Test
	public void testConstructor1() {
		LockedStorage ls = new LockedStorage("password");
		String error = String.format("LockedStorage: constructor1 failed");
		assertTrue(error, "".equals(ls.getContent()));
	}

	@Test
	public void testConstructor2() {
		LockedStorage ls = new LockedStorage("password", "Content");
		String error = String.format("LockedStorage: constructor2 failed");
		assertTrue(error, "Content".equals(ls.getContent()));
	}

	@Test
	public void testSetContent() {
		LockedStorage ls = new LockedStorage("password", "Content");
		String error = String.format("LockedStorage: setContent failed");
		assertTrue(error, !ls.isLocked());
		assertTrue(error, "Content".equals(ls.getContent()));
		assertTrue(error, ls.setContent("NewContent"));
		assertTrue(error, "NewContent".equals(ls.getContent()));

		ls.lock();
		try {
			ls.setPassword("");
			 error = String.format("setContent failed to throw an exception");
			fail(error);
		} catch (LockedStorageException x) {
			// ok
		} catch (Exception x) {
			fail("wrong type of exception thrown");
		}
	}

	@Test
	public void testGetContent() {
		LockedStorage ls = new LockedStorage("password", "Content");
		String error = String.format("LockedStorage: getContent failed");
		assertTrue(error, !ls.isLocked());
		assertTrue(error, "Content".equals(ls.getContent()));

		ls.lock();
		try {
			ls.setPassword("");
			 error = String.format("getContent failed to throw an exception");
			fail(error);
		} catch (LockedStorageException x) {
			// ok
		} catch (Exception x) {
			fail("wrong type of exception thrown");
		}

	}
	
	@Test
	public void testSetPassword() {
		LockedStorage ls = new LockedStorage("password", "Content");
		String error = String.format("LockedStorage: setPassword failed");
		assertTrue(error, !ls.isLocked());
		ls.setPassword("newPassword");
		ls.lock();
		assertTrue(error, ls.isLocked());
		assertTrue(error, !ls.unlock("password"));
		assertTrue(error, ls.isLocked());
		assertTrue(error, ls.unlock("newPassword"));
		assertTrue(error, !ls.isLocked());

		ls.lock();
		try {
			ls.setPassword("");
			 error = String.format("setPassword failed to throw an exception");
			fail(error);
		} catch (LockedStorageException x) {
			// ok
		} catch (Exception x) {
			fail("wrong type of exception thrown");
		}

	}

	@Test
	public void testLock() {
		LockedStorage ls = new LockedStorage("password", "Content");
		String error = String.format("LockedStorage: lock failed");
		assertTrue(error, !ls.isLocked());
		ls.lock();
		assertTrue(error, ls.isLocked());
	}
	
	@Test
	public void testUnlock() {
		LockedStorage ls = new LockedStorage("password", "Content");
		String error = String.format("LockedStorage: unlock failed");
		assertTrue(error, !ls.isLocked());
		ls.lock();
		assertTrue(error, ls.isLocked());
		assertTrue(error, !ls.unlock("abc"));
		assertTrue(error, ls.isLocked());
		assertTrue(error, ls.unlock("password"));
		assertTrue(error, !ls.isLocked());
	}
	

	@Test
	public void testToString() {
		LockedStorage ls = new LockedStorage("password", "Content");
		String error = String.format("LockedStorage: toString failed");
		assertTrue(error, "Content:\nContent".equals(ls.toString()));
		ls.lock();
		assertTrue(error, "LOCKED".equals(ls.toString()));
	}
}
