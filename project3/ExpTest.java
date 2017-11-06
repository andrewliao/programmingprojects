package project3;

import static org.junit.Assert.*;
/**
 * This class test an Exponential Function.
 * @author Andrew Liao
 */

import org.junit.Test;

public class ExpTest {

	@Test
	public void testValue() {
		/** create a Exp object with the input of a variable */
		Exp x = new Exp(new Variable());
		try {
			/** calling value with no input should return an error*/
			x.value();
		} catch(Exception exc) {
			/** making sure that it throws an UnsupportedOperationException */
			assertTrue(exc instanceof UnsupportedOperationException);
		}
		/** making sure that it inputs the right Exp value of 10 */
		assertTrue(x.value(10) == 22026.465794806703);
	}
	
	@Test
	public void testDerivative() {
		/** creating an BinaryOp that is the operand 10 * x */
		BinaryOp x = new BinaryOp(BinaryOp.Op.MULTIPLY, new Number(10), new Variable());
		/** creating a Exp object */
		Exp y = new Exp(x);
		/** printing out the Exp function */
		assertTrue(y.toString().compareTo("Exp[10.0 * x]") == 0.0);
		/** testing to make sure that the derivative is correct */
		assertTrue(y.derivative().toString().compareTo("Exp[10.0 * x] * ((x * 0.0) + (1.0 * 10.0))") == 0.0);
	}
	
	@Test
	public void testEquals() {
		/** creating a Exp with a Number operand of 10 */
		Exp x = new Exp(new Number(10));
		/** creating a second Exp with a Number operand of 10 */
		Exp y = new Exp(new Number(10));
		/** create a Exp object with the input of a variable */
		Exp z = new Exp(new Variable());
		/** comparing x and y which should be true */
		assertTrue(x.equals(y) == true);
		/** comparing x and z which are not the same log value functions */
		assertTrue(x.equals(z) == false);
	}
}
