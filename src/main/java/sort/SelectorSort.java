package sort;

import java.util.Arrays;

public class SelectorSort {

    public static void main(String[] args) {
        int[] arr = {2, 1, 9, 4, 5, 8, 6};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void selectSort(int[] arr) {

        //时间复杂度 O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }
}
