package leetcodestudy;

public class LeetCode42 {
    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
    }

    public static int trap(int[] height) {
        //1. 分别找到 当前列左右两边的最大长度的列
        //2. 只有当这两列的值均大于当前列的高度才能存储水
        int sum=0;
        for(int i=1;i<height.length-1;i++){
            int left = i-1, right = i+1;
            int left_max=0, right_max=0;
            while(left>=0){
                if (height[left]>left_max)
                    left_max=height[left];
                left--;
            }
            while(right<height.length){
                if (height[right]>right_max)
                    right_max=height[right];
                right++;
            }
            //找出两端的最小值
            int min = Math.min(left_max,right_max);
            if(min>height[i]){
                sum+=(min-height[i]);
            }
        }
        return sum;
    }
}
