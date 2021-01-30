package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 7, 5, 6};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if(left<right){
            int mid = (left + right) / 2;
            //左边切分
            mergeSort(arr, left, mid, temp);
            //右边切分
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }


    }

    /**
     *
     * @param arr 原数组
     * @param left 左边的索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 临时数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        /**
         * 第一步，将左右两边的数据按照顺序填充到temp数组中，直到其中一边填充完毕
         */
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            }
            if (arr[j] < arr[i]) {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        /**
         * 第二步，将剩下一边的未填充到temp里面的数据，填充到里面
         */
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }

        /**
         * 将temp数据，复制到原来的数组里
         */
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }

    }
}
