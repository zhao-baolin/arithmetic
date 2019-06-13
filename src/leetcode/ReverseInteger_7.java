package leetcode;

import java.util.Stack;

/**
 * 整数反转
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseInteger_7 {
    public static int reverse(int x) {
        String str = String.valueOf(x);
        Stack stack = new Stack();
        char[] arr = str.toCharArray();
        String symbol = ('+' == arr[0] || '-' == arr[0]) ? String.valueOf(arr[0]) : "";
        int start = symbol.equals("") ? 0 : 1;
        for(int i=start;i<arr.length;i++){
            stack.push(arr[i]);
        }
        String value = symbol;
        for (int i=start;i<arr.length;i++){
            value += stack.pop();
        }
        Integer result = 0;
        try{
            result = Integer.valueOf(value);
        }catch (Exception e){
        }
        return result;
    }


    public static void main(String[] args) {
        int in = -120;
        int result = reverse(in);
        System.out.println(result);
    }

}
