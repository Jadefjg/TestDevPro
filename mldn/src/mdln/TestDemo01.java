package mdln;

import java.util.Arrays;
import java.util.Comparator;


class Person{
	
	private String name;
	private int age;
	
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString(){
		return "Person [name=" + name + ", age" + age + "]\n";
	}
	
	public int getAge(){
		return age;
	}
	public String getName(){
		return name;
	}
}


class PersonComparator implements Comparator<Person>{
	public int compare(Person o1,Person o2){
		if(o1.getAge() > o2.getAge()){
			return 1;
		}else if (o1.getAge() < o2.getAge()){
			return -1;
		}else{
			return 0;
		}
	}
}


public class TestDemo01 {
	public static void main(String[] args) throws Exception{
		Person per[] = new Person[] {new Person("小",20),new Person("明",19),new Person("哈",21)};
		Arrays.sort(per); 
		System.out.println(Arrays.toString(per));
	}
}


