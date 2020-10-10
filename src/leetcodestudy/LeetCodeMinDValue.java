package leetcodestudy;

import java.util.Arrays;

public class LeetCodeMinDValue {
    public static void main(String[] args) {
        int[] a = {1, 3, 15, 11, 2};
        int[] b = {23, 127, 235, 19, 8};
        System.out.println(smallestDifference(a,b));
    }
    //面试题 16.06. 最小差
    public static int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long min = Integer.MAX_VALUE;
        for(int i = 0, j = 0;i < a.length && j < b.length;){
            long cur = Math.abs((long)a[i]-(long)b[j]);
            min = Math.min(cur,min);
            if(a[i] > b[j])
                j++;
            else i++;
        }
        return (int)min;
    }
}
