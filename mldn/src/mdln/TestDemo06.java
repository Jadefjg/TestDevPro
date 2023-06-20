package mdln;

class Point<T>{  //T:Type
	private T x;
	private T y;
	public void setX(int  x){
		this.x = y;
	}
	public void setY(int y){
		this.y = x;
	}
	public Object getX(){
		return x;
	}
	public Object getY(){
		return y;
	}
}


public class TestDemo06{
	public static void main(String[] args) throws Exception {
		// һ
		Point<String> point = new Point<String>();
		point.setX(10);
		point.setY(20);
		// һ
		int x = (Integer)point.getX();
		int y = (Integer)point.getY();
		System.out.println("X值是:"+x+",Y值是"+y);
	}
}
