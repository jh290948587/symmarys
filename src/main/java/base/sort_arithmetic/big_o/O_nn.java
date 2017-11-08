package base.sort_arithmetic.big_o;

/**
 * Created by Administrator on 2017/8/17.
 */

/**
 * 这个是O（n^2）
 */
public class O_nn {
    /**
     * (n-1) + (n-2) + (n-3) + ... + 0
     * =(0+n-1) * n/2
     * =(1/2)n * (n-1)
     * =1/2 * n^2 - 1/2 * n
     * =O(n^2)
     * @param arr
     * @param n
     */
    public static void selectionSort(int arr[],int n){
        for(int i = 0; i < n; i++){
            int minIndex = 1;
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            O_1.swapTwoInts(arr[i],arr[minIndex]);
        }
    }
}
