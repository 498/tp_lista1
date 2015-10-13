package number;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.After;

public class NumberTest {

	private Number number;

	@Before
	public void test_Number_isZeroAfterConstructor_true() {
		number = null; 
		assertNull(number);
		number = new Number();
		assertNotNull(number);
		assertEquals("not zero after constructor", 0, number.value);
	}
	
	@Test(timeout = 5)
	public void test_Number_isProperlyInitializedWithDecimalBase_true() {
		Number number;
		number = new Number(11);
		assertNotNull(number);
		assertEquals(11, number.value);
	}
	
	@Test
	public void test_Number_isProperlyInitializedWithNonDecimalBase_true() {
		Number number;
		number = new Number("ff", 16);
		assertNotNull(number);
		assertEquals(255, number.value);
	}
	
	@Test
	public void test_set_setsValue_true() {
		number.set(12);
		assertEquals(12, number.value);
	}
	
	@Test
	public void test_get_getsValue_true() {
		number.set(11);
		assertEquals(number.value, number.get());
	}
	
	@Test
	public void test_get_getsValueInBase16_true() {
		number.set(255);
		assertEquals("ff", number.get(16));
	}
	
	@Test
	public void test_get_getsValueInBase16Uppercase_false() {
		number.set(255);
		assertFalse("FF" == number.get(16));
	}
	
	@Test
	public void test_set_setsValueInBase16_true() {
		number.set("ff", 16);
		assertEquals("set doesn't work with base-16", 255, number.value);
	}
	
	@Test
	public void test_set_setsValueInBase16Uppercase_true() {
		number.set("FF", 16);
		assertEquals("set doesn't work with base-16", 255, number.value);
	}
	
	@After
	public void test_get_getsValueInBase2_true() {
		number.set(10);
		assertEquals("1010", number.get(2));
	}
	
	@Test
	public void test_set_setsValueInBase2_true() {
		number.set("1010", 2);
		assertEquals("set doesn't work with base-2", 10, number.value);
	}
	
	@Test(expected = NumberFormatException.class)
	public void test_set_setMeaninglessValue_exception() {
		number.set("s", 16);
		fail();
	}
	
	@Test(expected = NumberFormatException.class)
	public void test_set_setValueWithBaseTooSmall_exception() {
		number.set("3", 2);
		fail();
	}
	
	@Test(expected = NumberFormatException.class)
	@Ignore
	public void set_setWithBaseTooSmall_baseFixed() {
		number.set(5);
		// to przechodzi bo radix=10 is used instead
		assertEquals("5", number.get(1));
		fail();
	}
	
	
	
	
}