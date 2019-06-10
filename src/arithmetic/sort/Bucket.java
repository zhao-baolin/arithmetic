package arithmetic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/3
 */
public class Bucket {


    public static void sort(int[] arr){

        //最大最小值
        int max = arr[0];
        int min = arr[0];
        int length = arr.length;

        for(int i=1; i<length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            } else if(arr[i] < min) {
                min = arr[i];
            }
        }

        //最大值和最小值的差
        int diff = max - min;

        //桶列表
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for(int i = 0; i < length; i++){
            bucketList.add(new ArrayList<>());
        }

        //每个桶的存数区间
        float section = (float) diff / (float) (length - 1);

        //数据入桶
        for(int i = 0; i < length; i++){
            //当前数除以区间得出存放桶的位置 减1后得出桶的下标
            int num = (int) (arr[i] / section) - 1;
            if(num < 0){
                num = 0;
            }
            bucketList.get(num).add(arr[i]);
        }

        //桶内排序
        for(int i = 0; i < bucketList.size(); i++){
            //jdk的排序速度当然信得过
            Collections.sort(bucketList.get(i));
        }

        //写入原数组
        int index = 0;
        for(ArrayList<Integer> arrayList : bucketList){
            for(int value : arrayList){
                arr[index] = value;
                index++;
            }
        }
    }



    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 9, 7,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
