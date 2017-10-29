package project3;

public class Variable extends Functions {
	
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
	
	public String derivative() {
		return "1";
	}
	
	public String toString() {
		return representation;
	}
	
	public boolean equals(Object other) {
		if(other instanceOf Variable) {
			Variable x = (Variable) other;
			return x.toString()
		} else {
			return false;
		}
	}
}
