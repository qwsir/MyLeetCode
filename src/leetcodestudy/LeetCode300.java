package leetcodestudy;

import java.util.Arrays;

public class LeetCode300 {
    public static void main(String[] args) {
        int[] array = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(array));
    }
    public static int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int maxLen = 0;
        for(int i = 1;i<len;i++){
            for(int j = 0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}
