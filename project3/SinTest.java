package project3;

import static org.junit.Assert.*;
/**
 * This is a test for the Sin class.
 * @author Andrew Liao
 */

import org.junit.Test;

public class SinTest {

	@Test
	public void testValue() {
		/** create a Sin object with the input of a variable */
		Sin x = new Sin(new Variable());
		try {
			/** calling value with no input should return an error*/
			x.value();
		} catch(Exception exc) {
			/** making sure that it throws an UnsupportedOperationException */
			assertTrue(exc instanceof UnsupportedOperationException);
		}
		/** making sure that it inputs the right sin value of 10 */
		assertTrue(x.value(10) == -0.5440211108893698);
	}
	
	@Test
	public void testDerivative() {
		/** creating an BinaryOp that is the operand 10 * x */
		BinaryOp x = new BinaryOp(BinaryOp.Op.MULTIPLY, new Number(10), new Variable());
		/** creating a Sin object */
		Sin y = new Sin(x);
		/** printing out the Sin function */
		assertTrue(y.toString().compareTo("Sin[10.0 * x]") == 0.0);
		/** testing to make sure that the derivative is correct */
		assertTrue(y.derivative().toString().compareTo("Cos[10.0 * x] * ((x * 0.0) + (1.0 * 10.0))") == 0.0);
	}
	
	@Test
	public void testEquals() {
		/** creating a Sin with a Number operand of 10 */
		Sin x = new Sin(new Number(10));
		/** creating a second Sin with a Number operand of 10 */
		Sin y = new Sin(new Number(10));
		/** create a Sin object with the input of a variable */
		Sin z = new Sin(new Variable());
		/** comparing x and y which should be true */
		assertTrue(x.equals(y) == true);
		/** comparing x and z which are not the same log value functions */
		assertTrue(x.equals(z) == false);	
	}

}
