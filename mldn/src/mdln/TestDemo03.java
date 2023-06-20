package mdln;


public class TestDemo03{
	public static void main(String[] args) throws Exception{
		System.out.println(add(new int[] (1,2,3)));
		System.out.println(add(1,2,3));
		System.out.println(add());
	}
	public static int add(int[] ... data){ 
		int sum = 0;
		for(int x = 0;x<data.length;x++){
			sum += data[x];
		} 
		return sum;
	}
}
