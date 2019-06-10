package arithmetic.sort;

import java.util.Arrays;

/**
 * @Description 选择排序
 * @Author zhaobaolin
 * @Date 2019/5/30
 */
public class Select {
    public static void sort(int arr[])
    {
        for(int i=0;i<arr.length;i++){
            int min = i;//最小元素的下标
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] < arr[min]){
                    min = j;//找最小值
                }
            }
            //交换位置
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
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
