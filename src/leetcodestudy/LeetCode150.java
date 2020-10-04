package leetcodestudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LeetCode150 {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>(Arrays.asList("+","-","*","/"));
        for(int i = 0;i < len;i++){
            if(list.contains(tokens[i])){
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                Integer num3;
                if(tokens[i].equals("*")){
                  num3 = num1 * num2;
                }else if(tokens[i].equals("/")){
                    num3 = num1 / num2;
                }
                else if(tokens[i].equals("+")){
                    num3 = num1 + num2;
                }else num3 = num1 - num2;
                stack.push(num3);
            }else stack.push(Integer.valueOf(tokens[i]));
        }
        return stack.pop();
    }

}
