package leetcode;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 * String[] arr = str.split(",");
 */
public class LengthOfLastWord_58 {
    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        int len = arr.length;
        if(0 == len){
            return 0;
        }
        return arr[len-1].length();
    }

    //从后往前找
    public static int lengthOfLastWord2(String s) {
        s = s.trim();
        int len = s.length();
        if(0 == s.length()){
            return 0;
        }
        int num = 0;
        for(int i=len-1;i>=0;i--){
            char d = s.charAt(i);
            if(' ' == d){
                return num;
            }
            num++;
        }
        return num;
    }


    public static void main(String[] args) {

        //int[] in = {1,3,5,6};
        //int target = 5;

        //int[] in = {1,3,5,6};
        //int[] in = {-2,1,-3,4,-1,2,1,-5,4};
        //String in = "Hello World";
        String in = "a ";
        //String in = " ";
        int result = lengthOfLastWord2(in);
        System.out.println(result);
    }
}
