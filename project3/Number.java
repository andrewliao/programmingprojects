package project3;
/**
 * This class represents any number as a Function.
 * @author Andrew Liao
 *
 */

public class Number implements Function {
	
	/** This variable stores the value of the number */
	private double representation;
	
	/**
	 * This constructor creates a new Number object that represents a number as a function.
	 * @param num The value of the Number object.
	 */
	public Number(double num) {
		representation = num;
	}
	
	/**
	 * This method returns the value of Number. 
	 * @return The value that Number holds.
	 */
	public double value() {
		return representation;
	}
	
	/**
	 * This method return the value of the number placing input into every variable.
	 * @param input The value of every variable.
	 * @return The value that Number holds.
	 */
	public double value(double input) {
		return representation;
	}
	
	/**
	 * This method returns the derivative of the Number object.
	 * @return This returns a new Number object with the value of 0.
	 */
	public Function derivative() {
		return new Number(0);
	}
	
	/**
	 * This method shows the string representation of Number.
	 * @return This returns a String representation of Number.
	 */
	public String toString() {
		return String.valueOf(representation);
	}
	
	/**
	 * This method checks if two number objects are equal to each other by comparing their values.
	 * @param other The other object you are trying to compare to.
	 * @return The boolean result of the comparison of both objects.
	 */
	public boolean equals(Object other) {
		if(other instanceof Number) {
			/** x changes the current type of the other Object to Number */
			Number x = (Number) other;
			return this.value() == x.value();
		} else {
			return false;
		}
	}
}
