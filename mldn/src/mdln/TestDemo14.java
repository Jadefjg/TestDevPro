package mdln;

class Message{
	@Deprecated
	public void print(){
		System.out.println("sss");
	}
}

public class TestDemo14{
	@SuppressWarnings({"rawtypes","unused"})
	public static void main(String[] args) throws Exception{
		Message msg = new Message();
	}
}

