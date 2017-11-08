package base.sort_arithmetic.sort;

/**
 * Created by Administrator on 2017/8/18.
 */
public class SelectAndBubble {
    public static void main(String[] args) {
		/*int[] arr = {3,5,6,1,7,11,9,2};
		printArr(arr);
		bubbleSort(arr);
		printArr(arr);*/
        int[] arr = {1,5,8,11,15,17,22,24};
        int index = binarySearch(arr, 3);
        System.out.println(index);

    }
    /*
     * 数组折半查找
     */
    private static int binarySearch(int[] arr,int key){
        //定义三个变量，保存数组的下标，就是图中的指针
        int min = 0 ;
        int max = arr.length-1;
        int mid = 0 ;
        //开始循环折半，小针<=大针
        while(min <= max){
            mid = (min + max)/2;
            if(key < arr[mid])
                max = mid - 1;
            else if(key > arr[mid])
                min = mid + 1;
            else
                return mid;
        }
        return -1;
    }


    /*
     * 数组冒泡排序
     */
    private static void bubbleSort(int[] arr){
        for(int i = 0 ; i < arr.length ;i++){
            for(int j = 0 ; j < arr.length - i - 1 ; j++){
                if( arr[j] > arr[j+1])
                    swap(arr,j,j+1);
            }
        }
    }
    /*
     * 数组的选择排序
     */
    private static void selectSort(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i+1 ; j < arr.length ; j++){
                if(arr[i] > arr[j])
                    swap(arr,i,j);
            }
        }
    }
    /*
     * 定义方式实现数组换位
     */
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /*
     * 数组遍历
     */
    public static void printArr(int[] arr){
        System.out.print("[");
        for(int i = 0 ; i < arr.length ; i++){
            if(i == arr.length - 1)
                System.out.print(arr[i]);
            else
                System.out.print(arr[i]+",");
        }
        System.out.println("]");
    }
}
