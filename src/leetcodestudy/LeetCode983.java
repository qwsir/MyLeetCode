package leetcodestudy;

public class LeetCode983 {
    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println(mincostTickets(days,costs));
    }
    //思路二 https://www.cnblogs.com/ZJPaang/p/12835218.html
    public static int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int dayStart = days[0], dayEnd = days[len-1];
        int[] dp = new int[dayEnd+31];
        for(int day = dayEnd, index = len-1; day >= dayStart; day--){
            if(day == days[index]){ //说明这一天需要出行
                dp[day] = Math.min(dp[day+1]+costs[0],Math.min(dp[day+7]+costs[1],dp[day+30]+costs[2]));
                index--;
            }else
                dp[day] = dp[day+1]; //不需要出门
        }
        return dp[dayStart];
    }
}
