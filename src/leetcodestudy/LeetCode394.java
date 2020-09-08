package leetcodestudy;

import java.util.Stack;

public class LeetCode394 {
    public static void main(String[] args) {
        String s =  "abc3[cd]xyz";
        System.out.println(decodeString(s));
    }
    /**
     1.通过栈的方式存储元素，当遇到‘]’时进行出栈，然后分别收集字符串和其循环次数。
     2.将新增加的字符串重新压入栈中
     3.数组遍历完后所有元素出栈即可
     **/
    public static String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(chars[i]!=']'){
                stack.push(chars[i]);
            }
            else{
                StringBuilder str = new StringBuilder("");
                while(stack.peek()!='['){
                    str.append(stack.pop());
                }
                stack.pop();

                StringBuilder num = new StringBuilder("");
                while(!stack.isEmpty()&&Character.isDigit(stack.peek())){
                    num.append(stack.pop());
                }
                StringBuilder newstr = new StringBuilder("");
                int count = Integer.valueOf(num.reverse().toString());
                for(int j=0;j<count;j++){
                    newstr.append(str);
                }
                newstr.reverse();
                for(int k=0;k<newstr.length();k++){
                    stack.push(newstr.charAt(k));
                }

            }
        }
        StringBuilder string = new StringBuilder("");
        while(!stack.isEmpty()){
            string.append(stack.pop());
        }
        return string.reverse().toString();
    }
}
