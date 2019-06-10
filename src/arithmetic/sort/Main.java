package arithmetic.sort;

import java.util.HashSet;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/5/23
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {3,8,13,7,15,8,6,6};
        test(arr);
    }


    private static void test(int[] arr)
    {
        HashSet hashSet = new HashSet();
        for (int i=0;i<arr.length;i++){
            if(hashSet.contains(arr[i])){
                System.out.println("找到了："+arr[i]);
            }
            hashSet.add(arr[i]);
        }
    }

/*    private static void test(int[] arr)
    {
        for (int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j] == arr[i]){
                    System.out.println("找到了："+arr[i]);
                }
            }
        }
    }*/

}
