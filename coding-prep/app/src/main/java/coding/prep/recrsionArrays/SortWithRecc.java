package coding.prep.recrsionArrays;

import java.util.Arrays;

class SortWithRecc {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		int[] arr = new int[] { 4, 3, 2, 1 };
		bubbleSortWithRecc(arr, arr.length - 1, 0);

		// System.out.println(Arrays.toString(arr));

		// find max number in array
		int[] arr2 = new int[] { 1, 56, 3, 2, 4 };
		// System.out.println(findLrgstNoWithRecc(arr2,arr.length,0,0));

		selectionSortWithRecc(arr2, arr2.length, 0, 0);
		// System.out.println(Arrays.toString(arr2));

		int[] arr3 = new int[] { 1, 56, 3, 2, 4 };
		int[] mergedArray = mergeSortWithRecc(arr3);
		// System.out.println(Arrays.toString(mergedArray));

		// merge in place
		int[] arr4 = new int[] { 1, 56, 3, 2, 4 };
		mergeSortInPlace(arr4, 0, arr4.length);
		// System.out.println(Arrays.toString(arr4));

		// Quick Sort
		// 1,2,3,4,56
		int arr5[] = new int[] { 1, 67, 2, 5, 23 };
		quickSort(arr5, 0, arr5.length - 1);
		System.out.println(Arrays.toString(arr5));

		//Note: Quick Sort is not stable sort as it does not maintain the order of equal elements
	}

	static void selectionSortWithRecc(int[] arr, int row, int col, int max) {
		if (row == 0)
			return;

		if (col < row) {
			if (arr[col] > arr[max]) {
				selectionSortWithRecc(arr, row, col + 1, col);
			} else {
				selectionSortWithRecc(arr, row, col + 1, max);
			}
		} else {
			int temp = arr[max];
			arr[max] = arr[row - 1];
			arr[row - 1] = temp;
			selectionSortWithRecc(arr, row - 1, 0, 0);
		}
	}

	static void bubbleSortWithRecc(int[] arr, int r, int c) {
		if (r == 0) {
			return;
		}

		if (c < r) {
			if (arr[c] > arr[c + 1]) {
				int temp = arr[c];
				arr[c] = arr[c + 1];
				arr[c + 1] = temp;
			}
			bubbleSortWithRecc(arr, r, c + 1);
		} else {
			bubbleSortWithRecc(arr, r - 1, 0);
		}
	}

	public static int[] mergeSortWithRecc(int[] arr) {
		if (arr.length <= 1)
			return arr;

		int middle = arr.length / 2;
		int[] first = mergeSortWithRecc(Arrays.copyOfRange(arr, 0, middle));
		int[] second = mergeSortWithRecc(Arrays.copyOfRange(arr, middle, arr.length));
		return getMergedArrays(first, second);
	}

	static int[] getMergedArrays(int[] first, int[] second) {
		int i = 0, j = 0, k = 0;
		int[] mergedArray = new int[first.length + second.length];

		while (first.length > i && second.length > j) {
			if (first[i] < second[j]) {
				mergedArray[k] = first[i];
				i++;
				k++;
			} else {
				mergedArray[k] = second[j];
				j++;
				k++;
			}
		}

		while (i < first.length) {
			mergedArray[k] = first[i];
			i++;
			k++;
		}

		while (j < second.length) {
			mergedArray[k] = second[j];
			j++;
			k++;
		}
		return mergedArray;
	}

	static void mergeSortInPlace(int[] arr, int s, int e) {
		if (e - s == 1)
			return;

		int m = s + (e - s) / 2;
		mergeSortInPlace(arr, s, m);
		mergeSortInPlace(arr, m, e);
		mergeInPlace(arr, s, m, e);
	}

	static void mergeInPlace(int[] arr, int s, int m, int e) {
		int i = s, j = m, k = 0;
		int[] mergedArray = new int[e - s];

		while (i < m && j < e) {
			if (arr[i] < arr[j]) {
				mergedArray[k] = arr[i];
				i++;
				k++;
			} else {
				mergedArray[k] = arr[j];
				j++;
				k++;
			}
		}

		while (i < m) {
			mergedArray[k] = arr[i];
			i++;
			k++;
		}

		while (j < e) {
			mergedArray[k] = arr[j];
			j++;
			k++;
		}

		for (int l = 0; l < mergedArray.length; l++) {
			arr[s + l] = mergedArray[l];
		}
	}

	static void quickSort(int[] arr, int low, int high) {
		if (low >= high)
			return;

		int s = low;
		int e = high;
		int m = s + (e - s) / 2;
		int p = arr[m];

		while (s <= e) {
			// move pointer od s to pos until the condition of arr's > arr'p fails
			while (arr[s] < p) {
				s++;
			}

			// move pointer of e to pos until the condition of arr'e > arr'p fails
			while (arr[e] > p) {
				e--;
			}

			if (s <= e) {
				int temp = arr[s];
				arr[s] = arr[e];
				arr[e] = temp;
				s++;
				e--;
			}
		}

		// once after ensuring no elements between low and high lie at wrong place from
		// pivot
		// as we know after above while loop s will move till end and e will move
		// forwaord to start
		// we need to esnure pivot policy is maintained in both arrays

		quickSort(arr, low, e);
		quickSort(arr, s, high);
	}

}
