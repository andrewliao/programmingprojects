package project3;

public class Exp extends Type {
	
	public Exp(Function operand) {
		super(operand);
	}
	
	public double value() {
		return Math.pow(Math.E, this.getOperand().value());
	}
	
	public double value(double input) {
		return Math.pow(Math.E, this.getOperand().value(input));
	}
	
	
	public Function derivative() {
		return new BinaryOp(Operator.MULTIPLY, this, this.getOperand().derivative());
	}
	
	public String toString() {
		return "Exp[" + this.getOperand().toString() + "]";
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
