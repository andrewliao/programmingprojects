package project3;

public class Polynomial implements Function {
	
	private Function operand;
	private Number power;
	
	public Polynomial(Function operand, double power) {
		this.operand = operand;
		this.power = new Number(power);
	}
	
	public double value() {
		throw new UnsupportedOperationException();
	}
	
	public double value(double input) {
		return Math.pow(this.getOperand().value(), this.getPower().value());
	}
	
	public Function derivative() {
		if(this.power.value() > 1) {
			return new BinaryOp (Operator.MULTIPLY, new BinaryOp(Operator.MULTIPLY, this.getPower(), this.getOperand()), this.getOperand().derivative());
		} else if (this.power.value() == 1) {
			return this.getOperand().derivative();
		} else {
			 return new BinaryOp(Operator.DIVIDE, new BinaryOp(Operator.MULTIPLY, this.getPower(), this.getOperand()), this.getOperand().derivative());
		}
	}
	
	public Function getOperand() {
		return this.operand;
	}
	
	public Number getPower() {
		return this.power;
	}
	
	public String toString() {
		if(this.operand instanceof BinaryOp) {
			return "(" + this.getOperand().toString() + ")";
		} else {
			return this.getOperand().toString() + "^" + power;
		}
	}
	
	public boolean equals(Object other) {
		if(other instanceof Polynomial) {
			Polynomial otherObject = (Polynomial) other;
			if(this.operand == otherObject.operand && this.power == otherObject.getOperand()) {
				return true;
			} else {
				return false;
			}
		}  else {
			return false;
		}
	}
	
}
