package mdln;

class MyMath {
	public static int add(int x,int y){
		return x + y;
	}
	
	public static int sub(int x,int y){
		return x - y;
	}
	
	public static int mul(int x,int y){
		return x * y;
	}
	
	public static int div(int x,int y){
		return x / y;
	}
}


public class TestDemo05{
	public static void main(String[] args) throws Exception{
		System.out.println("加法:" + MyMath.add(10,20));
		System.out.println("减法:" + MyMath.sub(20,30));
	}
}
