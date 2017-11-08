package base.sort_arithmetic.sort;




public class ArrayDemo {
	public static void main(String[] args) {
		int[] arr = {3,5,6,4,7,11,9,10};
//		printArr(arr);
		bubbleSort(arr);
//		printArr(arr);
//		int[] arr = {1,5,8,11,15,17,22,24};
//		int index = binarySearch(arr, 3);
//		selectSort(arr);
//		System.out.println();
	    for(int i : arr){
            System.out.print(i+ ",");
        }
	}




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
	
	


	private static void bubbleSort(int[] arr){
		for(int i = 0 ; i < arr.length-1 ;i++){
			for(int j = 0 ; j < arr.length - i - 1 ; j++){
				if( arr[j] > arr[j+1])
			         swap(arr,j,j+1);
			}
		}
	}


	private static void selectSort(int[] arr){
		for(int i = 0 ; i < arr.length-1 ; i++){
			for(int j = i+1 ; j < arr.length ; j++){
				if(arr[i] > arr[j])
					swap(arr,i,j);
			}
		}
	}


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
