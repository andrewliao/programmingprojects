package project3;
/**
 * Testing the Log class.
 * @author Andrew Liao
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class LogTest {

	@Test
	public void testValue() {
		/** create a Log object with the input of a variable */
		Log x = new Log(new Variable());
		try {
			/** calling value with no input should return an error*/
			x.value();
		} catch(Exception exc) {
			/** making sure that it throws an UnsupportedOperationException */
			assertTrue(exc instanceof UnsupportedOperationException);
		}
		/** making sure that it inputs the right natural log value of 10 */
		assertTrue(x.value(10) == 2.302585092994046);
	}
	
	@Test
	public void testDerivative() {
		/** creating an BinaryOp that is the operand 10 * x */
		BinaryOp x = new BinaryOp(BinaryOp.Op.MULTIPLY, new Number(10), new Variable());
		/** creating a Log object */
		Log y = new Log(x);
		/** printing out the log function */
		assertTrue(y.toString().compareTo("Log[10.0 * x]") == 0.0);
		/** testing to make sure that the derivative is correct */
		assertTrue(y.derivative().toString().compareTo("(1.0 / (10.0 * x)) * ((x * 0.0) + (1.0 * 10.0))") == 0.0);
	}
	
	@Test
	public void testEquals() {
		/** creating a Log with a Number operand of 10 */
		Log x = new Log(new Number(10));
		/** creating a second Log with a Number operand of 10 */
		Log y = new Log(new Number(10));
		/** create a Log object with the input of a variable */
		Log z = new Log(new Variable());
		/** comparing x and y which should be true */
		assertTrue(x.equals(y) == true);
		/** comparing x and z which are not the same log value functions */
		assertTrue(x.equals(z) == false);
		
	}

}
