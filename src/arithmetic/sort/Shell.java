package arithmetic.sort;

import java.util.Arrays;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/5
 */
public class Shell {

    public static void sort(int[] arr) {
        int length = arr.length;

        //区间
        int gap = 1;
        while (gap < length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                //跨区间排序
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = gap / 3;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,2,5,9,7,10,1,15,12,3};
        //int[] arr = {9,8,7,6,5};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
