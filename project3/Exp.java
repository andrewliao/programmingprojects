package project3;
/**
 * This class represents the Function and Type Function for an exponential function.
 * @author Andrew Liao
 *
 */

public class Exp extends Type {
	
	/**
	 * A constructor of Exp which will just call the constructor of its parent class of Type.
	 * @param operand This is the parameter needed for the superclass constructor.
	 */
	public Exp(Function operand) {
		super(operand);
	}
	
	/**
	 * This returns the value of the Function Exp.
	 * @return The value of e raised to a certain operand.
	 */
	public double value() {
		return Math.pow(Math.E, this.getOperand().value());
	}
	
	/**
	 * This returns the value of Function Exp but with the double value of input in place of any variable x.
	 * @param input This is the value of any variable x.
	 * @return This returns the value of the Exp function.
	 */
	public double value(double input) {
		return Math.pow(Math.E, this.getOperand().value(input));
	}
	
	/**
	 * This returns the derivative of an Exp Function.
	 * @return This returns the derivative of an Exp Function, which must also incorporate chain rule.
	 */
	public Function derivative() {
		return new BinaryOp(BinaryOp.Op.MULTIPLY, this, this.getOperand().derivative());
	}
	
	/**
	 * This returns a String representation of Exp Function.
	 * @return the String representation of the Exp Function.
	 */
	public String toString() {
		return "Exp[" + this.getOperand().toString() + "]";
	}
	
	/**
	 * This checks if another object is equal to this current Exp Function object.
	 * @param other This is the other object which we will be comparing to.
	 * @return This returns whether or not this Exp object equals the other object by comparing operands.
	 */
	public boolean equals(Object other) {
		if(other instanceof Exp) {
			/** This changes the current type of other to being an Exp Function. */
			Exp otherObject = (Exp) other;
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
