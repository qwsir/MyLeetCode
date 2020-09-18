package leetcodestudy;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCodeSwap {
    public static void main(String[] args) {
        int[] array1 = {519, 886, 282, 382, 662, 4718, 258, 719, 494, 795};
        int[] array2 = {52, 20, 78, 50, 38, 96, 81, 20};
        int[] swapValues = findSwapValues(array1, array2);
        for (int t : swapValues)
            System.out.print(t+"\t");

    }
    //面试题16.21 交换和
    public static int[] findSwapValues(int[] array1, int[] array2) {
        int sum1=0,sum2=0;
        for(int c:array1) sum1+=c;
        for(int c:array2) sum2+=c;
        int target = sum1>sum2?sum1-sum2:sum2-sum1;
        if(target%2!=0) return new int[]{};
        target/=2;
        Arrays.sort(array2);//先排序再二分搜索
        if(sum1<sum2)
        {
            for(int i=0;i<array1.length;i++)
            {
                int idx=Arrays.binarySearch(array2,array1[i]+target);
                if(idx>=0) return new int[]{ array1[i],array2[idx]};
            }
        }else {
            for(int i=0;i<array1.length;i++)
            {
                int idx=Arrays.binarySearch(array2,array1[i]-target);
                if(idx>=0) return new int[]{ array1[i],array2[idx]};
            }
        }
        return new int[]{};
    }
}
