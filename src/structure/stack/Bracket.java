package structure.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/5/26
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 例如：
 * 输入: "()"  输出: true
 * 输入: "()[]{}" 输出: true
 * 输入: "(]" 输出: false
 * 输入: "([)]" 输出: false
 * 输入: "{[]}" 输出: true
 * 输入: "(([]){})" 输出: true
 */
public class Bracket {
    private Map map;
    private Stack stack;

    public Bracket() {
        map = new HashMap();
        map.put("(",")");
        map.put("{","}");
        map.put("[","]");
    }

    public boolean isValid(String s) {
        this.stack = new Stack();

        s = s.trim();
        int len = s.length();
        for(int i=0;i<len;i++){
            String str = s.substring(i,i+1);

            if(this.stack.empty()){
                stack.push(str);
                continue;
            }

            String peek = (String)stack.peek();

            //如果栈顶的元素不是该符号的对应 则判断该符号是否是起始符号
            if(str.equals(map.get(peek))){
                stack.pop();
            }else{
                if(map.containsKey(str)){
                    stack.push(str);
                }else{
                    return false;
                }
            }
        }
        return this.stack.empty();
    }

    public static void main(String[] args) {
        Bracket bracket = new Bracket();
        System.out.println(bracket.isValid("()"));  // true
        System.out.println(bracket.isValid("()[]{}")); // true
        System.out.println(bracket.isValid("(]"));  // false
        System.out.println(bracket.isValid("([)]"));    // false
        System.out.println(bracket.isValid("{[]}"));    // true
        System.out.println(bracket.isValid("(([]){})"));    // true
    }
}
