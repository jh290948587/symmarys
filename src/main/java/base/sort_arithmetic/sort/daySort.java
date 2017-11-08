package base.sort_arithmetic.sort;

public class daySort {

	/**
	 * 直接插入
	 *
	 * @param arr
	 */
	public void insertSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int insertNum = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] < insertNum) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = insertNum;
		}
	}

	/**
	 * 希尔排序
	 *
	 * @param arr
	 */
	public void shellSort(int[] arr) {
		int n = arr.length;
		int d = n / 2;
		while (d > 0) {
			for (int i = 0; i < d; i++) {
				for (int j = i + d; j < n; j += d) {
					int k = j - d;
					int insertNum = arr[j];
					while (k >= 0 && insertNum < arr[k]) {
						arr[k + d] = arr[k];
						k -= d;
					}
					arr[k + d] = insertNum;
				}
			}
			d /= 2;
		}
	}

	/**
	 * 交换排序 - 冒泡排序
	 *
	 * @param arr
	 */
	public void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	/**
	 * 选择排序 - 堆排序
	 *
	 * @param arr
	 */
	public void heapSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			buildMaxHeap(arr, n - i - 1);
			swap(arr, 0, n - i - 1);
		}
	}

	private void buildMaxHeap(int[] arr, int lastIndex) {
		for (int i = (lastIndex - 1) / 2; i > 0; i--) {
			int k = i;
			int bIndex = 2 * i + 1;
			while (2 * k + 1 < lastIndex) {
				if (bIndex < lastIndex && arr[bIndex] < arr[bIndex + 1]) {
					bIndex++;
				}

				if (arr[i] > arr[bIndex])
					break;
				swap(arr, i, bIndex);
				k = bIndex;
			}
		}
	}

	/**
	 * 交换排序
	 *
	 */
	public void selectSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int min = arr[i];
			for (int j = i + 1; j < n; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			if (min != i) {
				swap(arr, min, i);
			}
		}
	}

	/**
	 * 快速排序，是对冒泡排序的优化
	 *
	 * @param arr
	 */
	public static void quickSort(int[] arr) {

		int n = arr.length;
		quickSort(arr, 0, n - 1);
	}

	private static void quickSort(int[] arr, int l, int r) {
		if (l >= r) {
			return;
		}
		int p = partition(arr, l, r);
		quickSort(arr, l, p-1);
		quickSort(arr, p + 1, r);
	}

	/**
	 * 返回p ,使得arr[l,p-1] < arr[p] arr[p]=<arr[p+1,r]
	 *
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	private static int partition(int[] arr, int l, int r) {

		int v = arr[l];
		int j = l;

		for (int i = l + 1; i <= r; i++) {
			if (arr[i] < v) {
				swap(arr, ++j, i);
			}
		}
		swap(arr, l, j);
		return j;
	}

	/**
	 * 返回p ,使得arr[l,p-1] <= arr[p] arr[p]<=arr[p+1,r],当有重复数据时效率更高
	 *
	 * @param arr
	 * @param l
	 * @param r
	 * @return
	 */
	private int partition2(int[] arr, int l, int r) {
		int v = arr[l];
		int i = l + 1, j = r;
		while (true) {
			while (i <= r && arr[i] < v)
				i++;
			while (j >= l + 1 && arr[j] > v)
				j--;
			if (i > j) {
				break;
			}
			swap(arr, i, j);
			i++;
			j--;
		}
		swap(arr, l, j);
		return j;
	}

	/**
	 * 归并排序
	 *
	 * @param arr
	 */
	public void megeSort(int[] arr) {
		int n = arr.length;
		mergeSort(arr, 0, n - 1);
	}

	private void mergeSort(int[] arr, int l, int r) {
		int mid = l + (r - l) / 2;
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		if (arr[mid] < arr[mid + 1]) {
			mergeAll(arr, l, r, mid);
		}
	}

	private void mergeAll(int[] arr, int l, int r, int mid) {
		int[] tmp = new int[r - l + 1];
		for (int i = l; i < r; i++) {
			tmp[i - 1] = arr[i];
		}

		int i = l, j = mid + 1, k = l;
		while (k <= r) {
			if (i > mid) {
				arr[k++] = tmp[j];
				j++;
			} else if (j > r) {
				arr[k++] = tmp[i];
				i++;
			} else if (arr[i] < arr[j]) {
				arr[k++] = tmp[i];
				i++;
			} else if (arr[i] >= arr[j]) {
				arr[k++] = tmp[j];
				j++;
			}
		}

	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
