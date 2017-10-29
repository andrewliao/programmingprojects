package project3;

public class Variable extends Function {
	
	private String representation;
	
	public Variable() {
		representation = "x";
	}
	
	public double value(double input) {
		return input;
	}
	
	public double value() {
		throw new UnsupportedOperationException();
	}
	
	public Function derivative() {
		return new Number(1);
	}
	
	public String toString() {
		return representation;
	}
	
	public boolean equals(Object other) {
		if(other instanceof Variable) {
			Variable x = (Variable) other;
			return x.toString() == this.toString();
		} else {
			return false;
		}
	}
}
