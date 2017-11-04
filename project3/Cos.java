package project3;

public class Cos extends Type {
	
	public Cos(Function operand) {
		super(operand);
	}
	
	public double value() {
		return Math.cos(this.getOperand().value());
	}
	
	public double value(double input) {
		return Math.cos(this.getOperand().value(input));
	}
	
	public Function derivative() {
		return new BinaryOp(Operator.MULTIPLY, new BinaryOp(Operator.MULTIPLY, new Number(-1), new Sin(this.getOperand())), this.getOperand().derivative());
	}
	
	public String toString() {
		return "Cos[" + this.getOperand().toString() + "]";
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
