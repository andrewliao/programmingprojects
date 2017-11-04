package project3;
/**
 * This class represents a Sin function which is a Type and also a Function.
 * @author andrewliao
 *
 */

public class Sin extends Type {
	
	/**
	 * A constructor of Sin which will just call the constructor of its parent class of Type.
	 * @param operand This is the parameter needed for the superclass constructor.
	 */
	public Sin(Function operand) {
		super(operand);
	}
	
	/**
	 * This returns the value of the Function Sin.
	 * @return This returns the result of calling Math.sin of the operand.
	 */
	public double value() {
		return Math.sin(this.getOperand().value());
	}
	
	/**
	 * This returns the value of Function Sin but with the double value of input in place of any variable x.
	 * @param input This is the value of any variable x.
	 * @return This returns the value of the Sin function.
	 */
	public double value(double input) {
		return Math.sin(this.getOperand().value(input));
	}
	
	/**
	 * This returns the derivative of a Sin Function.
	 * @return This returns the derivative of a Sin Function, which must also incorporate chain rule.
	 */
	public Function derivative() {
		return new BinaryOp(Operator.MULTIPLY, new Cos(this.getOperand()), this.getOperand().derivative());
	}
	
	/**
	 * This returns a String representation of Sin Function.
	 * @return the String representation of the Sin Function.
	 */
	public String toString() {
		return "Sin[" + this.getOperand().toString() + "]";
	}
	
	/**
	 * This checks if another object is equal to this current Sin Function object.
	 * @param other This is the other object which we will be comparing to.
	 * @return This returns whether or not this Sin object equals the other object by comparing operands.
	 */
	public boolean equals(Object other) {
		if(other instanceof Sin) {
			/** This changes the current type of other to Sin. */
			Sin otherObject = (Sin) other;
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
