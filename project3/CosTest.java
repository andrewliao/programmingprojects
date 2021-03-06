package project3;
/**
 * This class represents a JUnit test unit for Cosine Function
 * @author Andrew Liao
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class CosTest {

	@Test
	public void testValue() {
		/** create a Cos object with the input of a variable */
		Cos x = new Cos(new Variable());
		try {
			/** calling value with no input should return an error*/
			x.value();
		} catch(Exception exc) {
			/** making sure that it throws an UnsupportedOperationException */
			assertTrue(exc instanceof UnsupportedOperationException);
		}
		/** making sure that it inputs the right cos value of 10 */
		assertTrue(x.value(10) == -0.8390715290764524);
	}
	
	@Test
	public void testDerivative() {
		/** creating an BinaryOp that is the operand 10 * x */
		BinaryOp x = new BinaryOp(BinaryOp.Op.MULTIPLY, new Number(10), new Variable());
		/** creating a Cos object */
		Cos y = new Cos(x);
		/** printing out the Cos function */
		assertTrue(y.toString().compareTo("Cos[10.0 * x]") == 0.0);
		/** testing to make sure that the derivative is correct */
		assertTrue(y.derivative().toString().compareTo("(-1.0 * Sin[10.0 * x]) * ((x * 0.0) + (1.0 * 10.0))") == 0.0);
	}
	
	@Test
	public void testEquals() {
		/** creating a Cos with a Number operand of 10 */
		Cos x = new Cos(new Number(10));
		/** creating a second Cos with a Number operand of 10 */
		Cos y = new Cos(new Number(10));
		/** create a Cos object with the input of a variable */
		Cos z = new Cos(new Variable());
		/** comparing x and y which should be true */
		assertTrue(x.equals(y) == true);
		/** comparing x and z which are not the same log value functions */
		assertTrue(x.equals(z) == false);
	}

}
