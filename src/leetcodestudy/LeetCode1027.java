package leetcodestudy;

import java.util.HashMap;

public class LeetCode1027 {
    public static void main(String[] args) {
        int[] array = {20,1,15,3,10,5,8};
        System.out.println(longestArithSeqLength(array));
    }
    public static int longestArithSeqLength(int[] A) {
        int len = A.length;
        if(A == null || len == 0)
            return 0;
        if(len == 1)
            return 1;
        HashMap<Integer,Integer>[] dp = new HashMap[len];
        int res = 2;   //初始任意两个数均为等差数列
        for(int i = 0;i < len;i++){
            dp[i] = new HashMap<>();
            for(int j = 0;j < i;j++){
                int num = A[j] - A[i];  //查看两元素之间的差值
                if(dp[j].containsKey(num)){
                    dp[i].put(num,dp[j].getOrDefault(num,0)+1);
                }else{
                    dp[i].put(num,2);
                }
                res = Math.max(res,dp[i].get(num));
            }
        }
        return res;
    }
}
