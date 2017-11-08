package base.set;
/*
 * �ַ����ĳ�������
 * ��Ҫʹ�ñȽ���
 */
import java.util.*;
public class TreeSetTest {
	public static void main(String[] args) {
	//	TreeSet<String> ts = new TreeSet<String>(new StringLengthComparator());
		TreeSet<String> ts = new TreeSet<String>(new Comparator<String>(){
			public int compare(String s1,String s2){
				int length = s1.length() - s2.length();
				return length==0?s1.compareTo(s2):length;
			}
		});
		ts.add("rhhd3");
		ts.add("u5yegf");
		ts.add("63teqgdv");
		ts.add("3werf");
		ts.add("jthfbgdv");
		Iterator<String> it = ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
