package sort.java_method;

/*
 * 自定义的比较器，比较Student对象中的成员
 * 年龄为主要条件
 */
//import java.util.Comparator;
public class StudentComparator implements java.util.Comparator<Student>{
	/*
	 *compare方法是集合调用
	 *后进去的对象传递给s1,先进去的传递给s2
	 */
	public int compare(Student s1, Student s2){
		int num = s1.getAge() - s2.getAge();
		return num == 0 ? s1.getName().compareTo(s2.getName()) : num;
	}
}
