package base.set;
/*
 * TreeSet���ϴ洢�Զ���Student����
 * ���ݱȽ���
 */
import java.util.*;
public class TreeSetDemo2 {
	public static void main(String[] args) {
		//StudentComparator��Comparator�ӿڵ�ʵ������󣬶��󴫵ݵ�TreeSet������
		TreeSet<Student> ts = new TreeSet<Student>(new StudentComparator());
		ts.add(new Student("zhangsan",15));
		ts.add(new Student("lisi",25));
		ts.add(new Student("lisi",25));
		ts.add(new Student("lilei",17));
		ts.add(new Student("lialei",17));
		ts.add(new Student("hanmeimei",12));
		Iterator<Student> it = ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
}
