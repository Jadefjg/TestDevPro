package mdln;


interface Message<T>{
	public String echo(T msg);
}

class MessageImpl<T> implements Message<T>{
	public String echo(T msg){
		return "ECHO��"+msg;
	}
}

public class TestDemo08{
	public static void main(String[] args) throws Exception{
		Message<String> msg = new MessageImpl<String>();
		System.out.println(msg.echo("哈哈哈哈哈"));
	}
}