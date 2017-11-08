package sort.java_method;
//implements Comparable目的，让Student具备自然顺序
public class Student implements Comparable<Student>{
	private String name;
	private int age;
	
	public int compareTo(Student s){
		//姓名主要条件，先比较
		int num = this.name.compareTo(s.name);
		//如果num的值是0，说明姓名相同，比较年龄，如果不是0，直接返回num
		return num == 0 ?this.age - s.age : num;
	/*	if(num!=0)
			return num;
		else
			return this.age - s.age;*/
	}
	
	public Student(String name,int age){
		this.age = age;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public String toString(){
		return "Student " + name +"..."+ age;
	}
	//重写hashCode()，存储到哈希表中
	//依据同样是成员变量
	public int hashCode(){
		/*
		 * name 保存是姓名
		 * age  保存是年龄
		 * 目的：名字相同，年龄也相同，返回一样的哈希值
		 * a1  16 3056+16*23  3072  3088
		 * a2  15 3057+15*23  3072  3087
		 *
		 * 降低 不同名字，不同年龄算出相同的哈希值
		 */
		return name.hashCode() + age * 21;
	}
	
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		if( this == obj)
			return true;
		if(obj instanceof Student){
			Student s = (Student)obj;
			//比姓名和年龄，相同返回真，不同返回假  this s
			return this.name.equals(s.name) && this.age == s.age;
		}
		return false;
	}
}
