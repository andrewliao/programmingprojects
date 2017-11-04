package project3;

public class TestFile {
	public static void main(String[] args) {
		Variable x = new Variable();
		Sin y = new Sin(x);
		System.out.println(y);
		System.out.println(y.value(3.14));
		
	}
}
