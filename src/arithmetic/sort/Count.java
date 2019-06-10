package arithmetic.sort;

import java.util.Arrays;

/**
 * @Description 技术排序
 * @Author zhaobaolin
 * @Date 2019/6/2
 */
public class Count {


    public static void sort(int[] arr) {

        //找出数组中的最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //初始化计数数组
        int[] countArr = new int[max + 1];

        //计数
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
            arr[i] = 0;
        }

        //排序
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > 0) {
                arr[index++] = i;
            }
        }
    }

    public static void countingSort(int[] arr) {

        //找出数组中的最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        //初始化计数数组
        int[] countArr = new int[max + 1];

        //计数
        for (int i = 0; i < arr.length; ++i) {
            countArr[arr[i]]++;
        }

        //顺序累加
        for (int i = 1; i < max + 1; ++i) {
            countArr[i] = countArr[i-1] + countArr[i];
        }

        //排序后的数组
        int[] sortedArr = new int[arr.length];

        //排序
        for (int i = arr.length - 1; i >= 0; --i) {
            sortedArr[countArr[arr[i]]-1] = arr[i];
            countArr[arr[i]]--;
        }

        //将排序后的数据拷贝到原数组
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = sortedArr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 9, 7,5};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
