package project3;

/**
 * This class represents a type of function that calculates an operand, this includes Sin, Cos, Exp, and Log.
 * @author Andrew Liao
 *
 */

public abstract class Type implements Function {
	/** This stores a field that represents the operand of which the Type will calculate. */
	private Function operand;
	
	/**
	 * This constructor constructs a Type that sets its operand to be the input parameter.
	 * @param operand
	 */
	public Type(Function operand) {
		this.operand = operand;
	}
	
	/**
	 * This is the getter method for the operand.
	 * @return This will return the operand of the Type.
	 */
	public Function getOperand() {
		return this.operand;
	}
	
}
