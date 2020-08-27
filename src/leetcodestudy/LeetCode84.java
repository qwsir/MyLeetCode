package leetcodestudy;

import java.util.Stack;

public class LeetCode84 {
    public static void main(String[] args) {
        int[] heights={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        if(heights.length==0||heights==null)
            return 0;
        int maxArea=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            //如果非递增的情况下要进行出栈，并计算面积
            while(!stack.isEmpty()&&heights[i]<=heights[stack.peek()]){
                int top=stack.pop();
                int second=stack.isEmpty()?-1:stack.peek();
                maxArea=Math.max(maxArea,heights[top]*(i-second-1));
            }
            stack.push(i);
        }
        //如果序列一直为递增，那么遍历完后栈可能不为空
        while(!stack.isEmpty()){
            int top=stack.pop();
            int second=stack.isEmpty()?-1:stack.peek();
            maxArea=Math.max(maxArea,heights[top]*(heights.length-second-1));
        }
        return maxArea;
    }

}

