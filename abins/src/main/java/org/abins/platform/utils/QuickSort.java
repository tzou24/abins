package org.abins.platform.utils;

import java.util.Random;

/**
 * @description 整型快速排序
 * @author Administrator
 * @feature 比 java.util.Arrays.sort(int[] arrays); 速度要快
 */
public class QuickSort {

	private void quickSort(int[] arrays) {
		subQuickSort(arrays, 0, arrays.length - 1);
	}

	private void subQuickSort(int[] arrays, int start, int end) {
		if (start >= end) {
			return;
		}
		int middleIndex = subQuickSortCore(arrays, start, end);

		subQuickSort(arrays, start, middleIndex - 1);
		subQuickSort(arrays, middleIndex + 1, end);

	}

	private int subQuickSortCore(int[] arrays, int start, int end) {
		int middleValue = arrays[start];
		while (start < end) {
			while (arrays[end] >= middleValue && start < end) {
				end--;
			}
			arrays[start] = arrays[end];
			while (arrays[start] <= middleValue && start < end) {
				start++;
			}
			arrays[end] = arrays[start];
		}
		arrays[start] = middleValue;
		return start;
	}
	
	
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		Random random = new Random();
		System.out.println(random.nextInt(10));
		int[] arr = new int[1000000];
		for (int i = 0; i < 1000000; i++) {
			System.out.println();
			arr[i] = random.nextInt(1000000);
		}
//		int[] arrays = new int[] { 100, 1, 12, 2, 13, 3, 14, 4, 15, 5, 16, 17, 17,
//				177, 18, 8, 8, 19 };
		quickSort.quickSort(arr);
		long startTime = System.currentTimeMillis();
//		Arrays.sort(arr);
		long endTime = System.currentTimeMillis();
//		System.out.println(Arrays.toString(arrays));
		System.out.println(endTime - startTime);//110, 117, 112
		
		//JDK 1.8 Lambda 表达式
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
			}
		}).start();
		////////////////////////////////
//		new Thread(
//				() -> System.out.println("");
//		).start();
		/////////////////////////////
	}

}
