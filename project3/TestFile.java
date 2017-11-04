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
		
		Polynomial qw = new Polynomial(y, -3);
		Log za = new Log(qw);
		System.out.println(za);
		System.out.println(za.derivative());
		
		Exp m = new Exp(a);
		System.out.println(m);
		System.out.println(m.derivative());
		
		Polynomial mason11 = new Polynomial(y, 4);
		Exp mason1 = new Exp(mason11);
		Polynomial mason222 = new Polynomial(y, 2);
		BinaryOp mason22 = new BinaryOp(Operator.MULTIPLY, new Number(3), mason222);
		Sin mason2 = new Sin(mason22);
		BinaryOp mason = new BinaryOp(Operator.MULTIPLY, mason1, mason2);
		System.out.println(mason);
		System.out.println(mason.derivative());
		
		
	}
}
