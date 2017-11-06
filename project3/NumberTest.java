package project3;
/**
 * This class test the Number class.
 * @author Andrew Liao
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberTest {

	@Test
	public void testValue() {
		/** creating a Number object with the value of 10 */
		Number x = new Number(10);
		/** testing if the value of 10 with no input is equal to 10 */
		assertTrue(x.value() == 10);
		/** checking to confirm that a double input value has no effect on the value of a Number which should still be 10 */
		assertTrue(x.value(1000) == 10);
	}
	
	@Test
	public void testDerivative() {
		/** creating a Number object with a value of 20 */
		Number x = new Number(20);
		/** making sure that the toString method is 20.0 */
		assertTrue(x.toString().compareTo("20.0") == 0.0);
		/** making sure that a derivative of a Number is 0.0 */
		assertTrue(x.derivative().value() == 0.0);
	}
	
	@Test
	public void testEquals() {
		/** creating a Number object with a value of 20 */
		Number x = new Number(20);
		/** creating the second Number object with a value of 20 */
		Number y = new Number(20);
		/** creating the third Number object with a value of 10 */
		Number z = new Number(10);
		/** comparing first and second Number object which should be true because both values are 20 */
		assertTrue(x.equals(y) == true);
		/** comparing the first and the third Number object which should be unequal because one is 20 and one is 10 */
		assertTrue(x.equals(z) != true);
	}

}
