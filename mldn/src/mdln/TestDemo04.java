package mdln;

class TestMath{
	public static int div(int x,int y) throws Exception{
		int result = 0;
		result = x / y;
		return result;
	}
}

public class TestDemo04{
	public static void main(String[] args) throws Exception{
		int tempX = 10;
		int tempY = 2;
		int res = TestMath.div(tempX, tempY);  //
		System.out.println("哈哈:"+res);
	}
}