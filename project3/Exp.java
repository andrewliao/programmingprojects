package project3;

public class Exp implements Function {
	private Function operand;
	
	public Exp(Function operand) {
		this.operand = operand;
	}
	
	public double value() {
		return Math.pow(Math.E, this.getOperand().value());
	}
	
	public double value(double input) {
		return Math.pow(Math.E, this.getOperand().value(input));
	}
	
	public Function getOperand() {
		return this.operand;
	}
	
	public Function derivative() {
		return new BinaryOp(Operator.MULTIPLY, this, this.getOperand().derivative());
	}
	
	public String toString() {
		return "Exp[" + this.operand.toString() + "]";
	}
	
	public boolean equals(Object other) {
		if(other instanceof Exp) {
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
