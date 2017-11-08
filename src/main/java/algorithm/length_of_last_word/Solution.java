package algorithm.length_of_last_word;

/**
 * Created by Administrator on 2017/11/2.
 */
public class Solution {
    public static void main(String[] args) {
        int i = lengthOfLastWord("hello world hao");
        System.out.println(i);
    }

    public static int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
