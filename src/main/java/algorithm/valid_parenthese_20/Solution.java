package algorithm.valid_parenthese_20;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }


    public boolean valid(String s){
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for(char c: chars){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                switch (c){
                    case ')':
                        if(stack.isEmpty() || stack.pop() != '('){
                            return false;
                        }
                        break;
                    case ']' :
                        if(stack.isEmpty() || stack.pop() != '['){
                            return false;
                        }
                        break;
                    case '}' :
                        if(stack.isEmpty() || stack.pop() != '{'){
                            return false;
                        }
                        break;
                    default :
                        break;
                }
            }
        }
        return true;
    }
}
