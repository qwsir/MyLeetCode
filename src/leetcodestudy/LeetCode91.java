package leetcodestudy;

public class LeetCode91 {
    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }
    public static int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0:1;
        for(int i = 2; i <= len;i++){
            //从字符串的第 i 个字符开始遍历
            if(s.charAt(i-1) != '0'){
                dp[i] = dp[i-1];
            }
            //判断该字符与之前一个字符构成数字的合法性
            int num = (s.charAt(i-2) - '0')*10 + (s.charAt(i-1) - '0');
            if(num >= 10 && num <= 26){
                //如果数字合法则对dp[i]进行再次更新
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }
}
