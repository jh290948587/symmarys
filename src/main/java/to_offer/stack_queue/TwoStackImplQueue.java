package to_offer.stack_queue;

import java.util.Stack;

/**
 * Created by Administrator on 2018/5/30.
 */
public class TwoStackImplQueue {

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.pop());
        q.add(4);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());


    }

    static class MyQueue{
        private Stack<Integer> s1 = new Stack<Integer>();
        private Stack<Integer> s2 = new Stack<Integer>();

        public void add(int val){
            s1.add(val);
        }


        public int pop(){
            if(!s2.isEmpty()){
                return s2.pop();
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();

        }
    }

}
