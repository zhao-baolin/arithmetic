package arithmetic.sort;

import java.util.Arrays;

/**
 * @Description 插入排序
 * @Author zhaobaolin
 * @Date 2019/6/1
 */
public class Insert {

    // 插入排序，a 表示数组，n 表示数组大小
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int value = arr[i];
            int j = 0;//插入的位置
            for (j = i-1; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];//移动数据 腾出位置
                } else {
                    break;
                }
            }
            arr[j+1] = value; //插入数据
        }
    }



    public static void main(String[] args) {
        int[] arr = {8,2,5,9,7};
        //int[] arr = {9,8,7,6,5};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
