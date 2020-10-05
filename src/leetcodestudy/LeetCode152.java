package leetcodestudy;

public class LeetCode152 {
    public static void main(String[] args) {
        int[] nums = {-2,5,2,-0,1,-3,-4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curmax = 1;
        int curmin = 1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] < 0){
                int temp = curmax;
                curmax = curmin;
                curmin = temp;
            }
            //如果nums[i] = 0,则curmax和curmin均重置为0
            curmax = Math.max(curmax*nums[i],nums[i]);
            curmin = Math.min(curmin*nums[i],nums[i]);
            max = Math.max(max,curmax);
        }
        return max;
    }
}
