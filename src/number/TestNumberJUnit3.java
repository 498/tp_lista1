package number;

import junit.framework.TestCase;

public class TestNumberJUnit3 extends TestCase {
	private Number number;
	
	public TestNumberJUnit3() {
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		number = new Number();
	}
	
	public void test_Number_isZeroAfterConstructor_true() {
		Number number = null; 
		assertNull(number);
		number = new Number();
		assertNotNull(number);
		assertEquals("not zero after constructor", 0, number.value);
	}
	
	public void test_Number_isProperlyInitializedWithDecimalBase_true() {
		Number number;
		number = new Number(11);
		assertNotNull(number);
		assertEquals(11, number.value);
	}
	
	public void test_Number_isProperlyInitializedWithNonDecimalBase_true() {
		Number number;
		number = new Number("ff", 16);
		assertNotNull(number);
		assertEquals(255, number.value);
	}
	
	public void test_set_setsValue_true() {
		number.set(12);
		assertEquals(12, number.value);
	}
	
	public void test_get_getsValue_true() {
		number.set(11);
		assertEquals(number.value, number.get());
	}
	
	public void test_get_getsValueInBase16_true() {
		number.set(255);
		assertEquals("ff", number.get(16));
	}
	
	public void test_get_getsValueInBase16Uppercase_false() {
		number.set(255);
		assertFalse("FF" == number.get(16));
	}
	
	public void test_set_setsValueInBase16_true() {
		number.set("ff", 16);
		assertEquals("set doesn't work with base-16", 255, number.value);
	}
	
	public void test_set_setsValueInBase16Uppercase_true() {
		number.set("FF", 16);
		assertEquals("set doesn't work with base-16", 255, number.value);
	}
	
	public void test_get_getsValueInBase2_true() {
		number.set(10);
		assertEquals("1010", number.get(2));
	}
	
	public void test_set_setsValueInBase2_true() {
		number.set("1010", 2);
		assertEquals("set doesn't work with base-2", 10, number.value);
	}
}
