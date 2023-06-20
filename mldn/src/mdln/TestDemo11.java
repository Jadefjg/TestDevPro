package mdln;


enum Color{
	RED,GREEN,BLUE;
}

public class TestDemo11{
	public static void main(String[] args) throws Exception{
		Color c = Color.values();
		switch(c){	
			case RED:
				System.out.println("红色");
			case GREEN:
				System.out.println("绿色");
			case BLUE:
				System.out.println("蓝色");
		}
	}
}