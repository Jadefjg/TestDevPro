package mdln;

enum Sex{
	MALE("男"),FEMALE("女");
	private String title;
	private Sex(String title){
		this.title = title;
	}
	public String toString(){
		return this.title;
	}
}

class Person{
	private String name;
	private int age;
	private Sex sex;
	
	public Person(String name,int age,Sex sex){
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	public String toString(){
		return "名字:"+this.name + ",年龄:" + this.age + ",性别:" + this.sex;
	}
}

public class TestDemo13{
	public static void main(String[] args) throws Exception{
		Person per = new Person("风雨",20,Sex.MALE);
		System.out.println(per);
	}
}