package project3;

public class BinaryOp implements Function {
	
	private Function left, right;
	private Operator operator;
	
	
	public BinaryOp(Operator operator, Function left, Function right) {
		this.operator = operator;
		this.left = left;
		this.right = right;
	}
	
	public Operator getOperator() {
		return this.operator;
	}
	
	public Function getLeftOperand() {
		return this.left;
	}
	
	public Function getRightOperand() {
		return this.right;
	}
	
	public double value() {
		return left.value() + right.value();
	}
	
	public double value(double input) {
		
	}
	
	public Function derivative() {
		if(this.operator == Operator.DIVIDE) {
			BinaryOp numeratorLeftProduct = new BinaryOp(Operator.MULTIPLY, this.getRightOperand(), this.getLeftOperand().derivative());
			BinaryOp numeratorRightProduct = new BinaryOp(Operator.MULTIPLY, this.getRightOperand().derivative(), this.getLeftOperand());
			BinaryOp numerator = new BinaryOp(Operator.MINUS, numeratorLeftProduct, numeratorRightProduct);
			BinaryOp denominator = new BinaryOp(Operator.MULTIPLY, this.getRightOperand(), this.getRightOperand());
			return new BinaryOp(Operator.DIVIDE, numerator, denominator);
		} else if(this.operator == Operator.MULTIPLY) {
			BinaryOp numeratorLeftProduct = new BinaryOp(Operator.MULTIPLY, this.getRightOperand(), this.getLeftOperand().derivative());
			BinaryOp numeratorRightProduct = new BinaryOp(Operator.MULTIPLY, this.right.derivative(), this.getLeftOperand());
			return new BinaryOp(Operator.PLUS, numeratorLeftProduct, numeratorRightProduct);
		} else {
			return new BinaryOp(this.operator, this.getLeftOperand().derivative(), this.getRightOperand().derivative());
		}
	}
	
	public boolean equals(Object other) {
		if(other instanceof BinaryOp) {
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
	
	public String toString() {
		String result;
		if (this.getLeftOperand() instanceof BinaryOp) {
			result = "(" + this.getLeftOperand() + ")";
		} else {
			result = this.getLeftOperand().toString();
		}
		
		result = result + this.getOperator();
		
		if(this.getRightOperand() instanceof BinaryOp) {
			BinaryOp rightSide = (BinaryOp) this.getRightOperand();
			if(rightSide.getOperator() != this.getOperator()) {
				result = result + "(" + rightSide.getOperator() + ")";
			} else {
				result = this.getRightOperand().toString();
			}
		} else {
			result = this.getRightOperand().toString();
		}
		
		return result;
		
	}
}
