package to_offer.sort;

import java.util.ArrayList;

public class SmallestKNum {
    public ArrayList GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList aList = new ArrayList();
        if(input.length == 0 || k > input.length || k <= 0)
            return aList;
        int low = 0;
        int high = input.length-1;
        int index = Partition(input,input.length,low,high);
        while(index != k-1){
            if (index > k-1) {
                high = index-1;
                index = Partition(input,input.length,low,high);
            }else{
                low = index+1;
                index = Partition(input,input.length,low,high);
            }
        }
        for (int i = 0; i < k; i++)
            aList.add(input[i]);
        return aList;
    }

    //快速排序的分段，小于某个数的放在左边，大于某个数的移到右边
    public int Partition(int[] input,int k,int low,int high){
        int pivotkey = input[k-1];
        swap(input,k-1,low);
        while(low < high){
            while(low < high && input[high] >= pivotkey) {
                high--;
            }
            swap(input,low,high);
            while(low < high && input[low] <= pivotkey) {
                low++;
            }
            swap(input,low,high);
        }
        return low;
    }


    private void swap(int[] input, int low, int high) {
        int temp = input[high];
        input[high] = input[low];
        input[low] = temp;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{ 4, 5, 1, 6, 9, 11,  2, 7, 8 };
        ArrayList arrayList = new SmallestKNum().GetLeastNumbers_Solution(arrays, 4);
        System.out.println(arrayList);
    }
}
