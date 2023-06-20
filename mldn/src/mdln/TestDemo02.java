package mdln;

abstract class A {	
	public A(){	
		this.print();
	}
	public abstract void print();
}


class B extends A{
	private int data = 10;
	public B(int data){
		this.data = data;
	}
	public void print(){
		System.out.println("data = "+this.data);
	}
}


public class TestDemo02{
	public static void main(String[] args) throws Exception{
		new B(100);
	}
}
