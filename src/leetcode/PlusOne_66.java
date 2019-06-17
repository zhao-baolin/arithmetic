package leetcode;

import java.util.Arrays;

/**
 * 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne_66 {

    //垃圾代码 垃圾思路 不删  贴黑板上当做反面教材
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i=len-1;i>=0;i--){
            //正常情况 末尾小于9
            if(digits[i] != 9){
                digits[i] += 1;
                return digits;
            }else {
                //特殊情况 末尾等于9的时候

                //1.当前位已经是首位
                if(i - 1 < 0){
                    digits[i] = 1;
                    int[] arr = Arrays.copyOf(digits,len+1);
                    arr[len] = 0;
                    return arr;
                }else{
                    //2.当前位不是首位
                    digits[i] = 0;
                    continue;
                }
            }
        }
        return digits;
    }

    //马勒戈壁 牛逼
    public static int[] plusOne1(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0){
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }


    public static void main(String[] args) {
        //int[] in = {1,3,5,6};
        //int[] in = {1,3,5,9};
        int[] in = {9,9,9,9};

        System.out.println(Arrays.toString(in));
        int[] result = plusOne1(in);
        System.out.println(Arrays.toString(result));
    }
}
