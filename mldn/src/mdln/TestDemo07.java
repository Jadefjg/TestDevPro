package mdln;

class Message<T>{
	private String info;
	
	public void setInfo(String string){
		this.info = string;
	}
	
	public String getInfo(){
		return info;
	}
}

public class TestDemo07{
	public static void main(String[] args) throws Exception{
		Message<Integer> msg = new Message<Integer>();
		msg.setInfo("Hello World.");
		println(msg);	
	}
	
	public static void println(Message<Integer> msg){
		System.out.println(msg.getInfo());   
	}
	
	public static void print(Message<Integer> temp){
		System.out.println(temp.getInfo());   
	}
}