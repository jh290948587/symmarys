package base.sort_arithmetic.sort;




public class ArraySortDemo {
	public static void main(String[] args) {
		int[] arr = {3,5,6,4,7,11,9,10};
//		printArr(arr);
//		bubbleSort(arr);
//		printArr(arr);
//		int[] arr = {1,5,8,11,15,17,22,24};
//		int index = binarySearch(arr, 3);
		selectSort(arr);
//		System.out.println();
//		quickSort(arr,0,arr.length - 1);
//	    for(int i: arr){
//            System.out.print(i+ ",");
//        }
	}

	/**
	 * 快速排序
	 */
	private static void quickSort(int[] arr, int low, int high){
		if (low < high){
			int pivot=partition(arr, low, high);        //将数组分为两部分
			quickSort(arr, low, pivot-1);         //递归排序左子数组
			quickSort(arr, pivot+1, high);                  //递归排序右子数组
		}
	}

	/**
	 * 快排分区算法，在这里根据当前枢轴划分两个分区
	 * 一个分区大于枢轴，另一个分区小于枢轴，并且返回当前枢轴
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	private static int partition(int[] arr, int low, int high){
		int pivot = arr[low];//枢轴记录

		while (low < high){

			while (low < high && arr[high] >= pivot)
				--high;

			arr[low]=arr[high];
			//交换比枢轴小的记录到左端
			while (low < high && arr[low] <= pivot)
				++low;

			//交换比枢轴小的记录到右端
			arr[high] = arr[low];
		}

		//扫描完成，枢轴到位
		arr[low] = pivot;

		//返回的是枢轴的位置
		return low;
	}

	/**
	 * 二分查找
	 * @param arr
	 * @param key
	 * @return
	 */
	private static int binarySearch(int[] arr,int key){

		int min = 0 , max = arr.length-1,mid = 0 ;

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


	/**
	 * 冒泡排序
	 * @param arr
	 */
	private static void bubbleSort(int[] arr){
		for(int i = 0 ; i < arr.length-1 ;i++){
			for(int j = 0 ; j < arr.length - i - 1 ; j++){
				if( arr[j] > arr[j+1])
			         swap(arr,j,j+1);
			}
		}
	}

	/**
	 * 选择排序
	 * @param arr
	 */
	private static void selectSort(int[] arr){
		for(int i = 0 ; i < arr.length-1 ; i++){
			for(int j = i+1 ; j < arr.length ; j++){
				if(arr[i] > arr[j])
					swap(arr,i,j);
			}
		}
	}

	/**
	 * 元素交换
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}



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
