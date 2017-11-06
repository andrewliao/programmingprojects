package project3;
/**
 * This class represents Polynomial as a Function.
 * @author Andrew Liao
 *
 */

public class Polynomial implements Function {
	
	/** This field stores the operand of the polynomial. */
	private Function operand;
	/** This field stores the power of the Function as a Number object. */
	private Number power;
	
	/**
	 * This constructor construct a Polynomial with the operand raised to a certain power. 
	 * @param operand This stores the operand of the polynomial.
	 * @param power This stores the power of the polynomial.
	 */
	public Polynomial(Function operand, double power) {
		this.operand = operand;
		this.power = new Number(power);
	}
	
	/**
	 * This returns the value of the polynomial.
	 * @return This returns the value of the operand to a power.
	 */
	public double value() {
		return Math.pow(this.getOperand().value(), this.getPower().value());
	}
	
	/**
	 * This returns the value of the polynomial using input in place of x.
	 * @return This returns the value of the operand to a power.
	 */
	public double value(double input) {
		return Math.pow(this.getOperand().value(input), this.getPower().value(input));
	}
	
	/**
	 * The returns the derivative of the polynomial.
	 * @return This returns the value of the operand to a power.
	 */
	public Function derivative() {
		if(this.getPower().value() > 1) {
			return new BinaryOp (BinaryOp.Op.MULTIPLY, new BinaryOp(BinaryOp.Op.MULTIPLY, this.getPower(), new Polynomial(this.getOperand(), this.getPower().value() -1 )), this.getOperand().derivative());
		} else if (this.getPower().value() == 1) {
			return this.getOperand().derivative();
		} else {
			 return new BinaryOp(BinaryOp.Op.MULTIPLY, new BinaryOp(BinaryOp.Op.MULTIPLY, this.getPower(), this.getOperand().derivative()), new Polynomial(this.getOperand(), this.getPower().value() -1 ));
		}
	}
	
	/**
	 *  The getter method for the operand. 
	 *  @return This returns the operand which is a Function.
	 */
	public Function getOperand() {
		return this.operand;
	}
	
	/**
	 * The getter method for the power.
	 * @return This returns the power of the polynomial.
	 */
	public Number getPower() {
		return this.power;
	}
	
	/**
	 * This is the toString method which returns the String representation of a Polynomial.
	 * @return This returns a String representation of a Polynomial.
	 */
	public String toString() {
		if(this.operand instanceof BinaryOp) {
			return "(" + this.getOperand().toString() + ")" + "^" + this.getPower().toString();
		} else {
			return this.getOperand().toString() + "^" + this.getPower().toString();
		}
	}
	
	/**
	 * This compares another object to this current Polynomial object.
	 * @param other This is the other Object we will compare this Polynomial object to.
	 * @return This returns whether or not the other object is equal to this Polynomial object.
	 */
	public boolean equals(Object other) {
		if(other instanceof Polynomial) {
			/** This changes other Object to the current type of Polynomial */
			Polynomial otherObject = (Polynomial) other;
			if(this.getOperand() == otherObject.getOperand() && this.getPower() == otherObject.getPower()) {
				return true;
			} else {
				return false;
			}
		}  else {
			return false;
		}
	}
	
}
