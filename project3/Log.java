package project3;

public class Log extends Type {
	
	public Log(Function operand) {
		super(operand);
	}
	
	public double value() {
		return Math.log(this.getOperand().value());
	}
	
	public double value(double input) {
		return Math.log(this.getOperand().value(input));
	}
	
	public Function derivative() {
		return new BinaryOp(Operator.DIVIDE, new Number(1), this.getOperand().derivative());
	}
	
	public String toString() {
		return "Log[" + this.getOperand().toString() + "]";
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
