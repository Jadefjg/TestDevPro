package mdln;

import mdln.Enum.Color;

public abstract class Enum<E extends Enum<E>>
extends Object
implements Comparable<E>,Serializable


enum Color{
	RED("红色"),GREEN("绿色"),BLUE("蓝色");
	private String title;
	private Color(String title){
		this.title = title;
	}
	public String toString(){
		return this.title;
	}
}

public class TestDemo{
	public static void main(String[] args) throws Exception{
		Color c = Color.RED;
		System.out.println(c);
	}
}