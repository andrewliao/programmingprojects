package project3;

public class Log implements Function {
	
	private Function operand;
	
	public Log(Function operand) {
		this.operand = operand;
	}
	
	public double value() {
		return Math.log(this.getOperand().value());
	}
	
	public double value(double input) {
		return Math.log(this.getOperand().value(input));
	}
	
	public Function getOperand() {
		return this.operand;
	}
	
	public Function derivative() {
		return new BinaryOp(Operator.DIVIDE, new Number(1), this.getOperand().derivative());
	}
	
	public String toString() {
		return "Log[" + this.operand.toString() + "]";
	}
	
	public boolean equals(Object other) {
		if(other instanceof Log) {
			Log otherObject = (Log) other;
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
