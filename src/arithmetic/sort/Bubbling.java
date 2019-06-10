package arithmetic.sort;

import java.util.Arrays;

/**
 * @Description 冒泡
 * @Author zhaobaolin
 * @Date 2019/5/29
 */
public class Bubbling {
    public static void sort(int arr[])
    {
        for(int i=0;i<arr.length-1;i++){
            boolean isSort = true;
            for(int j=0;j<arr.length-1-i;j++){
                int temp = 0;
                if(arr[j] < arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSort = false;
                }
            }
            if(isSort){
                break;
            }
        }
    }

    public static void main(String[] args) {
        //int[] arr = {8,2,5,9,7};
        int[] arr = {9,8,7,6,5};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
