package project3;
/**
 * This class tests the BinaryOp class.
 * @author Andrew Liao
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryOpTest {

	@Test
	public void testGetter() {
		/** creating a BinaryOp operand that is x + 10 */
		BinaryOp sample = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(10));
		/** testing the toString() method which should return true */
		assertTrue(sample.toString().compareTo("x + 10.0") == 0.0);
		/** testing the getter method for operator */
		assertTrue(sample.getOperator() == BinaryOp.Op.PLUS);
		/** testing the getter method for left operand */
		assertTrue(sample.getLeftOperand().toString() == new Variable().toString());
		/** testing the getter method for the right operand */
		assertTrue(sample.getRightOperand().value() == new Number(10).value());
	}
	
	@Test
	public void testValue() {
		/** creating a BinaryOp that is x + 10 */
		BinaryOp first = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(10));
		/** testing the value() which has no input and should throw an error */
		try {
			/** calling value with no input */
			first.value();
		} catch(Exception exc) {
			/** checking if it throws an UnsupportedOperationException error */
			assertTrue(exc instanceof UnsupportedOperationException);
		}
		/** inputting value(10) 10 should return a value of 20 */
		assertTrue(first.value(10) == 20.0);
	}
	
	@Test
	public void testDerivative() {
		/** creating a BinaryOp with a + operator 10 + x */
		BinaryOp first = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(10));
		/** creating a BinaryOp with a - operator 10 - x */
		BinaryOp second = new BinaryOp(BinaryOp.Op.MINUS, new Variable(), new Number(10));
		/** creating a BinaryOp with a / operator 10 / x */
		BinaryOp third = new BinaryOp(BinaryOp.Op.DIVIDE, new Variable(), new Number(10));
		/** creating a BinaryOp with a * operator 10 * x */
		BinaryOp fourth = new BinaryOp(BinaryOp.Op.MULTIPLY, new Variable(), new Number(10));
		/** making sure that the derivative is correct for addition */
		assertTrue(first.derivative().toString().compareTo("1.0 + 0.0") == 0.0);
		/** making sure that the derivative is correct for subtraction */
		assertTrue(second.derivative().toString().compareTo("1.0 - 0.0") == 0.0);
		/** making sure that the derivative is correct for division */
		assertTrue(third.derivative().toString().compareTo("((10.0 * 1.0) - (0.0 * x)) / (10.0 * 10.0)") == 0.0);
		/** making sure that the derivative is correct for multiplication */
		assertTrue(fourth.derivative().toString().compareTo("(10.0 * 1.0) + (0.0 * x)") == 0.0);
	}
	
	public void testEqual() {
		/** creating a BinaryOp that is x + 10 */
		BinaryOp first = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(10));
		/** creating another BinaryOp that is x + 10 */
		BinaryOp second = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(10));
		/** creating a third BinaryOp that is x + 20 */
		BinaryOp third = new BinaryOp(BinaryOp.Op.PLUS, new Variable(), new Number(20));
		/** checking to make sure that first is equal to second */
		assertTrue(first.equals(second) == true);
		/** checking to make sure that the third is not equal to the first */
		assertTrue(first.equals(third) == false);
	}
	

}
