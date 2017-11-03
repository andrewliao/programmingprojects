package project3;

public class Cos implements Function {
	private Function operand;
	
	public Cos(Function operand) {
		this.operand = operand;
	}
	
	public double value() {
		return Math.cos(this.getOperand().value());
	}
	
	public double value(double input) {
		return Math.cos(this.getOperand().value(input));
	}
	
	public Function getOperand() {
		return this.operand;
	}
	
	public Function derivative() {
		return new BinaryOp(Operator.MULTIPLY, new BinaryOp(Operator.MULTIPLY, new Number(-1), new Cos(this.getOperand())), this.getOperand().derivative());
	}
	
	public String toString() {
		return "Cos[" + this.operand.toString() + "]";
	}
	
	public boolean equals(Object other) {
		if(other instanceof Cos) {
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
