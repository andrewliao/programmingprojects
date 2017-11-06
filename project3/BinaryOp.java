package project3;
/**
 * This class represents a Binary operator, which are two operands with one operator in the middle.
 * @author Andrew Liao
 *
 */

public class BinaryOp implements Function {
	
	/** These fields store the operands of the BinaryOp. */
	private Function left, right;
	/** This field stores the operator of BinaryOp. */
	private Op operator;
	
	/**
	 * The constructor creates a BinaryOp that stores the operator along with its operands.
	 * @param operator This represents the operator of the BinaryOp.
	 * @param left This represents the operand to the left of the operator.
	 * @param right This represents the operand to the right of the operator.
	 */
	public BinaryOp(Op operator, Function left, Function right) {
		this.operator = operator;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * This is the getter method for the operator.
	 * @return This returns the operator of the BinaryOp object.
	 */
	public Op getOperator() {
		return this.operator;
	}
	
	/**
	 * This is the getter method for the left operand.
	 * @return This returns any function which is the left operand of the BinaryOp.
	 */
	public Function getLeftOperand() {
		return this.left;
	}
	
	/**
	 * This is the getter method of the right operand of the BinaryOp.
	 * @return This returns any function which is the right operand of the BinaryOp.
	 */
	public Function getRightOperand() {
		return this.right;
	}
	
	/**
	 * This returns the value of the BinaryOp.
	 * @return This returns the double value of the BinaryOp. 
	 */
	public double value() {
		switch(operator) {
			case PLUS:
				return this.getLeftOperand().value() + this.getRightOperand().value();
			case MINUS:
				return this.getLeftOperand().value() - this.getRightOperand().value();
			case MULTIPLY:
				return this.getLeftOperand().value() * this.getRightOperand().value();
			case DIVIDE:
				return this.getLeftOperand().value() / this.getRightOperand().value();	
			default:
				return 0;
		}
				
	}
	
	/**
	 * This returns the value of the BinaryOp using input in place of any Variable x.
	 * @param input This represents the value of the Variable x.
	 * @return This returns the value of the BinaryOp.
	 */
	public double value(double input) {
		switch(operator) {
		case PLUS:
			return this.getLeftOperand().value(input) + this.getRightOperand().value(input);
		case MINUS:
			return this.getLeftOperand().value(input) - this.getRightOperand().value(input);
		case MULTIPLY:
			return this.getLeftOperand().value(input) * this.getRightOperand().value(input);
		case DIVIDE:
			return this.getLeftOperand().value(input) / this.getRightOperand().value(input);	
		default:
			return 0;
		}
	}
	
	/**
	 * This returns the derivative of the BinaryOp function.
	 * @return It return any type of Function representation of BinaryOp.
	 */
	public Function derivative() {
		if(this.getOperator() == Op.DIVIDE) {
			/** This stores the left part of the numerator of the derivative of a fractional BinaryOp. a.k.a low derivative high */
			BinaryOp numeratorLeftProduct = new BinaryOp(Op.MULTIPLY, this.getRightOperand(), this.getLeftOperand().derivative());
			/** This store the right part of the numerator of the derivative of a fractional BinaryOp. a.k.a. high derivative low */
			BinaryOp numeratorRightProduct = new BinaryOp(Op.MULTIPLY, this.getRightOperand().derivative(), this.getLeftOperand());
			/** This stores the BinaryOp representation of the numerator of the derivative of the BinaryOp which is the left part minus the right part. */
			BinaryOp numerator = new BinaryOp(Op.MINUS, numeratorLeftProduct, numeratorRightProduct);
			/** This stores the denominator representation of the derivative of a fractional BinaryOp. a.k.a Low squared */
			BinaryOp denominator = new BinaryOp(Op.MULTIPLY, this.getRightOperand(), this.getRightOperand());
			return new BinaryOp(Op.DIVIDE, numerator, denominator);
		} else if(this.getOperator() == Op.MULTIPLY) {
			/** This represents the left side of the derivative of a BinaryOp with a multiplication as an operator. a.k.a Left Operand Derivative Multiply Right Operand */
			BinaryOp numeratorLeftProduct = new BinaryOp(Op.MULTIPLY, this.getRightOperand(), this.getLeftOperand().derivative());
			/** This represents the right side of the derivative of a BinaryOp with a multiplication as an operator. a.k.a Derivative Left Operand Multiply Right Operand */
			BinaryOp numeratorRightProduct = new BinaryOp(Op.MULTIPLY, this.right.derivative(), this.getLeftOperand());
			return new BinaryOp(Op.PLUS, numeratorLeftProduct, numeratorRightProduct);
		} else {
			return new BinaryOp(this.getOperator(), this.getLeftOperand().derivative(), this.getRightOperand().derivative());
		}
	}
	
	/**
	 * This method compares this BinaryOp to another object.
	 * @param other This stores the other object that we will compare to this object.
	 * @return the boolean result if the other object is equal to this BinaryOp object by comparing the operands and the operator.
	 */
	public boolean equals(Object other) {
		if(other instanceof BinaryOp) {
			/** This stores the other object with the current type of BinaryOp instead of just Object. */
			BinaryOp otherObject = (BinaryOp) other;
			if(this.getOperator() == otherObject.getOperator() && this.getLeftOperand() == otherObject.getLeftOperand() && this.getRightOperand() == otherObject.getRightOperand()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * This method returns a String representation of BinaryOp.
	 * @return This returns the String representation of BinaryOp.
	 */
	public String toString() {
		/** This will store the String representation of the BinaryOp. */
		String result = "";
		/** This will store the operator sign of the BinaryOp. */
		String sign;
		switch(operator) {
		case PLUS:
			sign = " + ";
			break;
		case MINUS:
			sign = " - ";
			break;
		case MULTIPLY:
			sign = " * ";
			break;
		case DIVIDE:
			sign = " / ";
			break;
		default:
			sign = "";
		}
		
		if (this.getLeftOperand() instanceof BinaryOp) {
			result = "(" + this.getLeftOperand().toString() + ")";
		} else {
			result += this.getLeftOperand().toString();
		}
		
		result = result + sign;
	
		if(this.getRightOperand() instanceof BinaryOp) {
			/** This changes the current type of the right operand to a BinaryOp. */
			BinaryOp rightSide = (BinaryOp) this.getRightOperand();
			if(rightSide.getOperator() != this.getOperator()) {
				result = result + "(" + rightSide.toString() + ")";
			} else {
				result  += this.getRightOperand().toString();
			}
		} else {
			result  += this.getRightOperand().toString();
		}
		
		return result;
		
	}
	
	public enum Op {
		PLUS, MINUS, MULTIPLY, DIVIDE;
	}

}
