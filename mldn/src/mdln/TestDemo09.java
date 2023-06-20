package mdln;

public class TestDemo09{
	public static void main(String[] args) throws Exception{
		Integer result[] = get(1,2,3);
		for(int temp:result){		
			System.out.println(temp);
		}
	}
	
	public static<T> T[] get(T...args){
		return args;
	}
}