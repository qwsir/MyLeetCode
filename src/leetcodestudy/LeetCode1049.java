package leetcodestudy;

public class LeetCode1049 {
    public static void main(String[] args) {
       int[] stones = {2,7,4,1,8,1};
       System.out.println(lastStoneWeightII(stones));
    }
    public static int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = 0;
        for(int num : stones) sum += num;
        int[][] dp =new int[len+1][sum/2+1];
        for(int i = 1;i <= len;i++){
            for(int j = 1;j <= sum/2;j++){
                if(j >= stones[i-1])  //如果石头的重量小于现有背包重量
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-stones[i-1]]+stones[i-1]);
                else  //如果石头的重量大于现有背包的重量
                    dp[i][j] = dp[i-1][j];
            }
        }
        return sum-2*dp[len][sum/2];
    }
}
