package project3;
/**
 * This tests the Polynomial class
 * @author Andrew Liao
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomialTest {

	@Test
	public void testGetter() {
		/** creating a Polynomial operand that is x to the power of 3 */
		Polynomial x = new Polynomial(new Variable(), 3);
		/** testing the toString() method which should return true */
		assertTrue(x.toString().compareTo("x^3.0") == 0.0);
		/** testing the getter method for operand */
		assertTrue(x.getOperand().toString() == new Variable().toString());
		/** testing the getter method for power */
		assertTrue(x.getPower().value() == new Number(3).value());
	}
	
	@Test
	public void testValue() {
		/** creating a Polynomial operand that is x to the power of 3 */
		Polynomial x = new Polynomial(new Variable(), 3);
		try {
			/** calling value with no input */
			x.value();
		} catch(Exception exc) {
			/** checking if it throws an UnsupportedOperationException error */
			assertTrue(exc instanceof UnsupportedOperationException);
		}
		/** testing value(10) which should return 10 ^ 3 or 1000 */
		assertTrue(x.value(10) == 1000);
	}
	
	@Test
	public void testDerivative() {
		/** creating a Polynomial operand that is x to the power of 3 */
		Polynomial x = new Polynomial(new Variable(), 3);
		/** making sure that it returns a derivative of 3x^2 */
		assertTrue(x.derivative().toString().compareTo("(3.0 * x^2.0) * 1.0") == 0.0);
	}
	
	public void testEqual() {
		/** creating a Polynomial that is x to the power of 3 */
		Polynomial x = new Polynomial(new Variable(), 3);
		/** creating a Polynomial that is x to the power of 3 */
		Polynomial y = new Polynomial(new Variable(), 3);
		/** creating a Polynomial that is x to the power of 5 */
		Polynomial z = new Polynomial(new Variable(), 5);
		/** checking to make sure that first is equal to second */
		assertTrue(x.equals(y) == true);
		/** checking to make sure that the third is not equal to the first */
		assertTrue(x.equals(z) == false);
	}
	
}
