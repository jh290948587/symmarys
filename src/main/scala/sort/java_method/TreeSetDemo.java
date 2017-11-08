package sort.java_method;
/*
 * TreeSet���ϣ��洢�ַ���
 * ����Ч��
 */

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) throws InterruptedException {
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("theghg");
		ts.add("jnhbg");
		ts.add("wqedsf");
		ts.add("aszxd");
		ts.add("jnhbv");
		Iterator<String> it = ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		Thread.sleep(10000);
		TreeSet<Integer> ts2 = new TreeSet<Integer>();
		ts2.add(1235);
		ts2.add(213);
		ts2.add(235);
		ts2.add(8765);
		ts2.add(324);
		Iterator<Integer> it2 = ts2.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
	}
}
