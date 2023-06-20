package mdln;

interface Message{
	public String getColor();
}

enum Color implements Message{
	RED("红色"){
		public String getColor(){
			return this.toString();
		}
	},GREEN("绿色"){
		public String getColor(){
			return this.toString();
		}
	},BLUE("蓝色"){
		public  String getColor(){
			return this.toString();
		}
	};
	private String title;
	private Color(String title){
		this.title = title;
	}
	public String toString(){
		return this.title;
	}
	public abstract String getColor();  
}

public class TestDemo12{
	public static void main(String[] args) throws Exception{
		System.out.println(Color.RED.getColor());
	}
}