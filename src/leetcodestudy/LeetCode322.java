package leetcodestudy;

public class LeetCode322 {
    public static void main(String[] args) {
        int[] conins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(conins,amount));
    }
    public static int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        for(int i=1 ;i<dp.length;i++){
            //采用最大值会溢出
            dp[i] = 999999;
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
