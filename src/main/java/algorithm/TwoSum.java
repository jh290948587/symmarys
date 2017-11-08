package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/27.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr ={2,3,5,1,4,9,0,6,7};
        int sum = 7;
        List list = twoSum1(arr, sum);
        System.out.println(list);
    }

    /**
     * 双for循环穷举法
     * O(n^2)
     * @param arr
     * @param sum
     * @return
     */
    public static List twoSum1(int[] arr,int sum){
        List twoList = new ArrayList();
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                Map aMap = new HashMap();
                if(arr[i]+arr[j] == sum){
                    aMap.put(arr[i],arr[j]);
                    twoList.add(aMap);
                }
            }
        }
        return twoList;
    }

    /**
     * 使用hashmap获取sum - arr[i]
     * o(n)
     * @param arr
     * @param sum
     * @return
     */
    public static List twoSum2(int[] arr,int sum){
        Map<Integer,Integer> twoMap = new HashMap();
        List twoList = new ArrayList();
        for(int i = 0; i < arr.length; i++){
            Integer other = twoMap.get(sum - arr[i]);
            if(other != null){
                Map aMap = new HashMap();
                aMap.put(arr[i],arr[other]);
                twoList.add(aMap);
            }else{
                twoMap.put(arr[i],i);
            }
        }
        return twoList;
    }
}
