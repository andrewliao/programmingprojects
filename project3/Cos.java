package project3;
/**
 * This class represents a Cosine Function that is also a Type Function.
 * @author Andrew Liao
 *
 */

public class Cos extends Type {
	
	/**
	 * A constructor of Cos which will just call the constructor of its parent class of Type.
	 * @param operand This is the parameter needed for the superclass constructor.
	 */
	public Cos(Function operand) {
		super(operand);
	}
	
	/**
	 * This returns the value of the Function Cos.
	 * @return This returns the result of calling Math.cos of the operand.
	 */
	public double value() {
		return Math.cos(this.getOperand().value());
	}
	
	/**
	 * This returns the value of Function Cos but with the double value of input in place of any variable x.
	 * @param input This is the value of any variable x.
	 * @return This returns the value of the Cos function.
	 */
	public double value(double input) {
		return Math.cos(this.getOperand().value(input));
	}
	
	/**
	 * This returns the derivative of a Cos Function.
	 * @return This returns the derivative of a Cos Function, which must also incorporate chain rule.
	 */
	public Function derivative() {
		return new BinaryOp(Operator.MULTIPLY, new BinaryOp(Operator.MULTIPLY, new Number(-1), new Sin(this.getOperand())), this.getOperand().derivative());
	}
	
	/**
	 * This returns a String representation of Cos Function.
	 * @return the String representation of the Cos Function.
	 */
	public String toString() {
		return "Cos[" + this.getOperand().toString() + "]";
	}
	
	/**
	 * This checks if another object is equal to this current Cos Function object.
	 * @param other This is the other object which we will be comparing to.
	 * @return This returns whether or not this Cos object equals the other object by comparing operands.
	 */
	public boolean equals(Object other) {
		if(other instanceof Cos) {
			/** This changes the current type of other to become Cos. */
			Cos otherObject = (Cos)other;
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
