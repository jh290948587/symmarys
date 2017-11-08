package base.linkedlist;
/*
 * ��ʾLinkedList���з���
 */
import java.util.*;
public class LinkedListDemo1 {
	public static void main(String[] args) {
		method();
        method_1();
        method_2();
        method_3();
        method_4();
	}

    /*
     * LinkedList替换后的新方法
     */
    private static void method_4(){
        List l = new ArrayList();
        l.add("aaa");
        l.add("bbb");
        l.add("ccc");
        Object o = l.get(1);
    }
	/*
	 * LinkedList替换后的新方法
	 */
	private static void method_3(){
		LinkedList link = new LinkedList();
		link.offerFirst("abc1");
		link.offerFirst("abc2");
		link.offerFirst("abc3");
		link.offerFirst("abc4");
		link.get(2);
		link.remove(2);
		link.clear();
		System.out.println(link);
		System.out.println(link.pollFirst());
		System.out.println(link);
	}
	
	
	/*
	 * Object removeFirst()
	 * Object removeLast()
	 */
	private static void method_2(){
		LinkedList link = new LinkedList();
		link.add("abc1");
		link.add("abc2");
		link.add("abc3");
		link.addFirst("QQ");
		link.add("WWW");
		link.addLast("RRR");
		System.out.println(link);// qq 1 2 3 www rrr
		System.out.println(link.removeFirst());//1 2 3 www rrr
		System.out.println(link.removeLast());//1 2 3 www
		System.out.println(link);
	}
	
	/*
	 * Object getFirst()
	 * Object getLast()
	 * 没有元素，出现异常
	 */
	private static void method_1(){
		LinkedList link = new LinkedList();
		link.add("abc1");
		link.add("abc2");
		link.add("abc3");
		link.addFirst("QQ");
		link.add("WWW");
		link.addLast("RRR");
		link.clear();
		
		System.out.println(link);
		if(!link.isEmpty()){
		System.out.println(link.getLast());
		System.out.println(link.getFirst());
		}
		
	}
	
	/*
	 * addFirst
	 * addLast
	 */
	private static void method(){
		LinkedList link = new LinkedList();
		link.add("abc1");
		link.add("abc2");
		link.add("abc3");
		System.out.println(link);
        link.addFirst("abc4");
		link.addLast("abc6");
		link.addFirst("abc5");
		System.out.println(link);
	}
}
