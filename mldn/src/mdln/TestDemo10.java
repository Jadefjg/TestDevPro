package mdln;


class Color{
	private static final String RED = new Color("红色");
	private static final String GREEN = new Color("绿色");
	private static final String BLUE = new Color("蓝色");
	private String title;
	private Color(String title){
		this.title = title;
	}
	public String toString(){
		int ch;
		switch(ch){
		case 0:
			return RED;
		case 1:
			return GREEN;
		case 2:
			return BLUE;
		default: 
			return null;
		}
	}
	public static Color getInstance(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}

public class TestDemo10{
	public static void main(String[] args) throws Exception{
		Color c = Color.getInstance(0);
		System.out.println(c);
	}
}
