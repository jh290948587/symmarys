package base.sort_arithmetic;

/**
 * Created by Administrator on 2017/5/5.
 */
public class BinarySerach {
    public static void main(String[] args) {
        int[] arr = {2,7,9,14,44,99};
        int i = binarySearch(arr, 44);
        System.out.println(i);
    }
    public static int binarySearch(int[] arr, int key){
        int mid = 0;
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            mid = (low + high)/2;
            if(arr[mid] > key){
                high = mid - 1;
            }else if(arr[mid] < key){
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return 0;
    }
}
