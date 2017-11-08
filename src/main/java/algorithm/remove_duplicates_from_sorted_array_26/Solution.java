package algorithm.remove_duplicates_from_sorted_array_26;

/**
 * Created by Administrator on 2017/11/1.
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,2,4,6,7,7,9};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    /**
     * 1 2 2 4 6 7 7 9
     * 1 2 4 4 6 7 7 9
     * 1 2 4 6 6 7 7 9
     * 1 2 4 6 7 7 7 9
     * 1 2 4 6 7 9 7 9
     * 这个方法总是能把比较过的j的值赋给i，然后j++继续和上一个j即i比较
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int myRemoveDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 0;
        int sum = 0;
        for (int i = 0, j = nums.length - 1;i < j;) {
            if(sum == nums[i] + nums[j]){
                count++;

            }else{
                sum = nums[i] + nums[j];
            }
            j--;
        }
        return count;
    }
}
