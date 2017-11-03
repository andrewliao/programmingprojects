package project3;

public class Number implements Function {
	
	private double representation;
	
	public Number(double num) {
		representation = num;
	}
	public double value(double input) {
		return representation;
	}
	
	public double value() {
		return representation;
	}
	
	public Function derivative() {
		return new Number(0);
	}
	
	public String toString() {
		return String.valueOf(representation);
	}
	
	public boolean equals(Object other) {
		if(other instanceof Number) {
			Number x = (Number) other;
			return x.toString() == this.toString();
		} else {
			return false;
		}
	}
}
