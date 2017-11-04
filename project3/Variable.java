package project3;
/**
 * This class represents the Variable x as a Function.
 * @author Andrew Liao 
 *
 */

public class Variable implements Function {
	
	/** This variable stores a String representation of the variable */
	private String representation;
	
	/**
	 * This constructor creates a new Variable object that changes its representation to be "x"
	 */
	public Variable() {
		representation = "x";
	}
	
	/**
	 * This method returns the value of the variable object.
	 * @return The value of the Variable object.
	 * @exception java.lang.UnsupportedOperationException It returns this exception 
	 * because we never specified what the variable x represents. 
	 * 
	 */
	public double value() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This method returns the value of the variable object.
	 * @param input This is the value of the variable "x"
	 * @return The value of the variable.
	 */
	public double value(double input) {
		return input;
	}
	
	/**
	 * This method returns the derivative of a Variable.
	 * @return This returns a Number object of the value 1, which is always the derivative of "x".
	 */
	public Function derivative() {
		return new Number(1);
	}
	
	/**
	 * This method returns a String representation of the Variable.
	 * @return This returns the field representation of the variable.
	 */
	public String toString() {
		return representation;
	}
	
	/**
	 * This method compares if another object is equal to this variable object.
	 * @param other This is the other object that this variable is comparing to.
	 * @return It returns is other object has the same String representation as this variable String representation.
	 */
	public boolean equals(Object other) {
		if(other instanceof Variable) {
			/** x stores changes the current type of other from Object to Variable. */
			Variable x = (Variable) other;
			return x.toString() == this.toString();
		} else {
			return false;
		}
	}
}
