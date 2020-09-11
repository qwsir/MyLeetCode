package leetcodestudy;

import java.util.Scanner;

public class LeetCodeCoins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(waysToChange(n));
    }

    /** LeetCode 面试题 8.11硬币问题,类似于完全背包
     */
    public static int waysToChange(int n) {
        int[] coins = {1,5,10,25};
        int row = coins.length+1;
        int[][] dp = new int[row][n+1];
        for(int i=0;i<row;i++)
            dp[i][0] = 1;
        for(int i=1;i<row;i++){
            for(int j=1;j<n+1;j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = (dp[i-1][j]+dp[i][j-coins[i-1]])%1000000007;
                }
            }
        }
        return dp[row-1][n];
    }
}
