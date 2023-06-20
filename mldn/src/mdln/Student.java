package mdln;

import java.util.Arrays;

class Student implements Comparable<Student>{
	private String name;
	private int age;
	private double score;
	public Student(String name,int age,double score){
		this.name = name;
		this.age = age;
		this.score = score;
	}
	
	@Override
	public String toString(){
		return "Student [name="+name+",age="+age+",score="+score+"]\n";
	}
	
	@Override
	public int compareTo(Student o){
		if(this.score > o.score){
			return -1;
		}else if (this.score < o.score){
			return 1;
		}else{
			if(this.age > o.age){
				return 1;
			}else if(this.age < o.age){
				return -1;
			}else {
				return 0;
			}
		}
	}
}





//public class TestDemo{
//	public static void main(String[] args) throws Exception{
//		String str = "SMITH:19:90.1 | ALLEN:18:90.1 | KING:2-:95.2";
//		String regex = "{[a-zA-Z]+:\\d(1,3):\\d(1,3)(\\.\\d(1,2))?\\|)+([a-zA-Z]+:\\d(1,3):\\d(1,3)(\\.\\d(1,2))?}?";
//		if (str.matches(regex)){  // 符合验证要求
//			String result[] = str.split("\\|");		//拆分
//			Student stu[] = new Student[result.length];		// 此时的数组大小就对象数组大小
//			for (int x=0;x<result.length;x++){
//				String temp[] = result[x].split(":");
//				stu[x] = new Student(temp[0],Integer.parseInt(temp[1]),Double.parseDouble(temp[2]));
//			}
//		Arrays.sort(stu);
//		System.out.println(Arrays.toString(stu));
//		}else {
//			System.out.println("FLASE,输入非法!");
//		}
//	}
//}









