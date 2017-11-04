package project3;

public class TestFile {
	public static void main(String[] args) {
		Number x = new Number(10);
		System.out.println(x);
		
		Variable y = new Variable();
		System.out.println(y);
		Variable z = new Variable();
		System.out.println(z);
		
		BinaryOp a = new BinaryOp(Operator.DIVIDE, x, z);
		System.out.println(a);
		System.out.println(a.derivative());
		
		Polynomial b = new Polynomial(a, 3);
		System.out.println(b);
		System.out.println(b.derivative());
		
		Sin c = new Sin(b);
		System.out.println(c);
		System.out.println(c.derivative());
		
		Cos d = new Cos(b);
		System.out.println(d);
		System.out.println(d.derivative());
		
		BinaryOp u = new BinaryOp(Operator.DIVIDE, x, z);
		System.out.println(p);
		System.out.println(p.derivative());
		
		Exp m = new Exp(a);
		System.out.println(m);
		System.out.println(m.derivative());
		
	}
}
