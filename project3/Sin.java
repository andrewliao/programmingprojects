package project3;

public class Sin implements Function {
	
	private Function operand;
	
	public Sin(Function operand) {
		this.operand = operand;
	}
	
	public double value() {
		return Math.sin(this.getOperand().value());
	}
	
	public double value(double input) {
		return Math.sin(this.getOperand().value(input));
	}
	
	public Function getOperand() {
		return this.operand;
	}
	
	public Function derivative() {
		return new BinaryOp(Operator.MULTIPLY, new Cos(this.getOperand()), this.getOperand().derivative());
	}
	
	public String toString() {
		return "Sin[" + this.operand.toString() + "]";
	}
	
	public boolean equals(Object other) {
		if(other instanceof Sin) {
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
