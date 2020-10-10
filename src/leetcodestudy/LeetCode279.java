package leetcodestudy;

public class LeetCode279 {
    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2;i <= n;i++){
            int min = Integer.MAX_VALUE;
            //找出最接近i的平方数，两者之间的差值为dp[i-j*j],表示剩下的数的最少平方数
            for(int j = 1;j*j <= i;j++){
                min = Math.min(min, dp[i-j*j]);
            }
            //这里的1表示之前最接近i的平方数，例如dp[35]= dp[10] + 1(5*5)
            dp[i] = min+1;
        }
        return dp[n];
    }
}