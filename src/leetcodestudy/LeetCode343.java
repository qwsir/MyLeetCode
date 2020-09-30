package leetcodestudy;

public class LeetCode343 {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
    //尽量将整数切割成3的倍数
    public static int integerBreak(int n) {
        if(n == 1)
            return 0;
        else if(n == 2)
            return 1;
        else if(n == 3)
            return 2;
        int res = 1;
        while (n > 4) {
            n = n - 3;
            res*=3;
        }
        return res*n;
    }
}
