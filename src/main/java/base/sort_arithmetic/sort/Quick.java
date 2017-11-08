package base.sort_arithmetic.sort;


/**
 * Created by Administrator on 2017/8/18.
 */
public class Quick {
    public static void main(String[] args) {
        int[] arr = {6,8,3,0,4,2,1};
        sort(arr,0,arr.length - 1);
    }

    public static void sort(int[] arr, int low, int high) {
        
        int l = low;
        int h = high;
        int key = arr[low];
        while (l < h) {
            while (l < h && arr[h] >= key)
                h--;
            if (l < h) {
//                high索引的值和key值互换
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }

            while (l < h && arr[l] <= key)
                l++;

            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }
        System.out.print("l=" + (l + 1) + "h=" + (h + 1) + "key=" + key + "\n");
        if (l > low) sort(arr, low, l - 1);
        if (h < high) sort(arr, l + 1, high);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
