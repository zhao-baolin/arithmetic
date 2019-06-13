package leetcode;

/**
 * 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 示例 3:
 * 输入: ["dog"]
 * 输出: "dog"
 *
 * 示例 4:
 * 输入: ["","dog"]
 * 输出: ""
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix_14 {

    public static String longestCommonPrefix(String[] strs) {

        //数组中最小的元素的长度
        int minStrLength = 0;
        for(String str : strs){
            if(0 == str.length()){
                return "";
            }
            int len = str.length();
            if(0 == minStrLength || len < minStrLength){
                minStrLength = len;
            }
        }

        //返回的最终字符串数据
        String string = "";

        //循环对比
        for(int i=0;i<minStrLength;i++){
            String s = "";//存放相同的字符
            for(String str : strs){
                String ss = str.substring(i,i+1);//截取字符
                if("".equals(s)){
                    s = ss;
                }
                if(!s.equals(ss)){
                    return string;//如果字符不同 则游戏结束
                }
            }
            string += s;
        }
        return string;
    }


    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static String longestCommonPrefix3(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if(ans.equals("")) {
                return ans;
            }
        }
        return ans;
    }




    public static void main(String[] args) {
        String[] in = {"flower","flow","flight"};
        //String[] in = {"b"};
        String result = longestCommonPrefix3(in);
        System.out.println(result);
    }

}
