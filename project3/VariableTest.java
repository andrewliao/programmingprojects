package project3;
/**
 * This class test Variable class.
 * @author Andrew Liao
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class VariableTest {

	@Test
	public void testValue() {
		/** creating a new variable */
		Variable x = new Variable();
		try {
			/** calling value with no input */
			x.value();
		} catch(Exception exc) {
			/** checking if it throws an UnsupportedOperationException error */
			assertTrue(exc instanceof UnsupportedOperationException);
		}
		/** checking if value(10) sets the value of a variable to be 10.0 */
		assertTrue(10.0 == x.value(10));
	}

	@Test
	public void testDerivative() {
		/** creating a new variable */
		Variable x = new Variable();
		/** checking if the variable is represented by x */
		assertTrue(x.toString() == "x");
		/** checking if the derivative of x is 1.0 */
		assertTrue(x.derivative().value() == 1.0);
	}
	
	@Test
	public void testEquals() {
		/** creating a new variable */
		Variable y = new Variable();
		/** creating a second new variable */
		Variable x = new Variable();
		/** checking to make sure that y is equal to x */
		assertTrue(y.equals(x) == true);
	}	
	
}
