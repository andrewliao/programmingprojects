package project3;

public class Number extends Functions {
	
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
	
	public String derivative() {
		return "0";
	}
	
	public String toString() {
		return String.valueOf(representation);
	}
}
