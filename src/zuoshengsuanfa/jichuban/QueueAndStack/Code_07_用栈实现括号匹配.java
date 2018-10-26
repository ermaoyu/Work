package zuoshengsuanfa.jichuban.QueueAndStack;

import java.util.Stack;

/**
 *      毛毛雨     2018/10/25
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * */
public class Code_07_用栈实现括号匹配 {
    public static  boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < str.length();i++){
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '[')stack.push(c);
            else {
                if (stack.isEmpty())return false;
                char cs = stack.pop();
                if (c == ')' && cs != '('||
                    c == ']' && cs != '['||
                    c == '}' && cs != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
