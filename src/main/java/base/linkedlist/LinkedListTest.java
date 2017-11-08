package base.linkedlist;
/*
  * LinkedList实现堆栈和队列
 * 将功能封装到一个类中，创建对象，调用功能
 * 类中，封装LinkedList的功能，用户不直接面对LinkedList
 */
import java.util.*;

class Data{
	private LinkedList link ;
	Data(){ link = new LinkedList();}
	//对用户提供add方法
	public void add(Object o){
		link.add(o);
	}
	//对集合判断有没有元素
	public boolean isEmpty(){
		return !link.isEmpty();
	}
	//获取并移除元素
	public Object duiZhan(){
		return link.pollLast();
	}
	public Object duiLie(){
		return link.pollFirst();
	}
}


public class LinkedListTest {
	public static void main(String[] args) {
		Data d = new Data();
		d.add("abc1");
		d.add("abc2");
		d.add("abc3");
		while(d.isEmpty())
		System.out.println(d.duiZhan());
		
		/*new Data();
		LinkedList link = new LinkedList();
		link.add("abc1");
		link.add("abc2");
		link.add("abc3");
		link.add("abc4");
		while(!link.isEmpty()){
			System.out.println(link.pollFirst());
		}*/
		/*System.out.println(link.pollLast());
		System.out.println(link.pollLast());
		System.out.println(link.pollLast());
		System.out.println(link.pollLast());*/
	}
}
