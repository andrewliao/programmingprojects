package project3;
/**
 * This class represents a Logarithmic Function which is a Function and a Type Function.
 * @author Andrew Liao
 *
 */

public class Log extends Type {
	
	/**
	 * A constructor of Log which will just call the constructor of its parent class of Type.
	 * @param operand This is the parameter needed for the superclass constructor.
	 */
	public Log(Function operand) {
		super(operand);
	}
	
	/**
	 * This returns the value of the Function Log.
	 * @return The value of log of the operand.
	 */
	public double value() {
		return Math.log(this.getOperand().value());
	}
	
	/**
	 * This returns the value of Function Log but with the double value of input in place of any variable x.
	 * @param input This is the value of any variable x.
	 * @return This returns the value of the Log Function.
	 */
	public double value(double input) {
		return Math.log(this.getOperand().value(input));
	}
	
	/**
	 * This returns the derivative of a Log Function.
	 * @return This returns the derivative of a Log Function, which must also incorporate chain rule.
	 */
	public Function derivative() {
		return new BinaryOp(Operator.DIVIDE, new Number(1), this.getOperand().derivative());
	}
	
	/**
	 * This returns a String representation of Log Function.
	 * @return the String representation of the Log Function.
	 */
	public String toString() {
		return "Log[" + this.getOperand().toString() + "]";
	}
	
	/**
	 * This checks if another object is equal to this current Log Function object.
	 * @param other This is the other object which we will be comparing to.
	 * @return This returns whether or not this Log object equals the other object by comparing operands.
	 */
	public boolean equals(Object other) {
		if(other instanceof Log) {
			/** This changes the current type to a Log Function */
			Log otherObject = (Log) other;
			if(this.getOperand() == otherObject.getOperand()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}
