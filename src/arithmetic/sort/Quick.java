package arithmetic.sort;

import java.util.Arrays;

/**
 * @Description 快速排序
 * @Author zhaobaolin
 * @Date 2019/6/2
 */
public class Quick {


    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }
        //切分
        int pivotIndex = partition(arr, startIndex, endIndex);
        sort(arr, startIndex, pivotIndex-1);
        sort(arr, pivotIndex+1, endIndex);
    }


    /**
     * 双边扫描
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        int pivot = arr[startIndex];//取第一个元素为基准值

        while (true) {

            //从左往右扫描
            while (arr[left] <= pivot) {
                left++;
                if (left == right) {
                    break;
                }
            }

            //从右往左扫描
            while (pivot < arr[right]) {
                right--;
                if (left == right) {
                    break;
                }
            }

            //左右指针相遇
            if (left >= right) {
                break;
            }

            //交换左右数据
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        //将基准值插入序列
        int temp = arr[startIndex];
        arr[startIndex] = arr[right];
        arr[right] = temp;
        return right;
    }


    /**
     * 单边扫描
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition2(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];//取基准值
        int mark = startIndex;//Mark初始化为起始下标

        for(int i=startIndex+1; i<=endIndex; i++){
            if(arr[i]<pivot){
                //小于基准值 则mark+1，并交换位置。
                mark ++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        //基准值与mark对应元素调换位置
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }


    public static void main(String[] args) {
        int[] arr = {8,2,5,9,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
