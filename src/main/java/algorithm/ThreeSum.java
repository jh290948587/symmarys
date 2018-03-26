package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        List<List<Integer>> arrayLists = threeSum(new int[]{2, -1, -1,-1,2, 7,-3,-4,3,6,8},0);
        System.out.println(arrayLists);
    }

    public static List<List<Integer>> threeSum(int[] nums,int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len=nums.length;
//        至少要有三个数
        if(len<3)
            return res;
//        对数组排序
        Arrays.sort(nums);
//        遍历
        for(int i=0;i<len;i++){
//            如果最小的都大于target，则直接结束
            if(nums[i]>target)
                break;
//            从第二个起，如果有重复的数字，则从下一个开始找，知道找到不重复的三个数
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int begin=i+1,end=len-1;
            while(begin<end){
                int sum=nums[i]+nums[begin]+nums[end];
                if(sum==target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[begin]);
                    list.add(nums[end]);
                    res.add(list);
                    begin++;
                    end--;
                    while(begin<end && nums[begin]==nums[begin-1])
                        begin++;
                    while(begin<end && nums[end]==nums[end+1])
                        end--;
                }else if(sum>target)
                    end--;
                else
                    begin++;
            }
        }
        return res;
    }
}
