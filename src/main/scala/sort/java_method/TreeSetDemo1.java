package sort.java_method;
/*
 * TreeSet���ϴ洢�Զ������
 * Student
 */

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo1 {
	public static void main(String[] args) {
		TreeSet<Student> ts = new TreeSet<Student>();
		ts.add(new Student("zhangsan",15));
		ts.add(new Student("lisi",25));
		ts.add(new Student("lisi",25));
		ts.add(new Student("lilei",17));
		ts.add(new Student("hanmeimei",12));
		Iterator<Student> it = ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
