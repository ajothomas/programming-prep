package com.atzeus.algoarrays;

import java.util.Arrays;


public class MergeSortImpl {
  public static void main(String[] args) {
    int[] arr = {5, 6, 1, 2, 7, 9, 10, 11};
    System.out.println("Before merge-sort");
    System.out.println(Arrays.toString(arr));
    mergeSort(arr);
    System.out.println("After merge-sort");
    System.out.println(Arrays.toString(arr));
  }

  private static void mergeSort(int[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private static void sort(int[] arr, int start, int end) {
    if (start >= end) {
      return;
    }

    int mid = start + (end - start) / 2;
    sort(arr, start, mid);
    sort(arr, mid + 1, end);

    merge(arr, start, end, mid);
  }

  private static void merge(int[] arr, int start, int end, int mid) {
    int s1 = mid - start + 1;
    int s2 = end - mid;

    int[] arr1 = new int[s1];
    int[] arr2 = new int[s2];

    for (int i = 0; i < s1; ++i) {
      arr1[i] = arr[start + i];
    }

    for (int i = 0; i < s2; ++i) {
      arr2[i] = arr[mid + 1 + i];
    }

    int i = 0;
    int j = 0;
    int k = start;
    while (i < s1 && j < s2) {
      if (arr1[i] <= arr2[j]) {
        arr[k] = arr1[i];
        i++;
      } else {
        arr[k] = arr2[j];
        j++;
      }
      k++;
    }

    while (i < s1) {
      arr[k] = arr1[i];
      k++;
      i++;
    }

    while (j < s2) {
      arr[k] = arr2[j];
      k++;
      j++;
    }
  }
}
