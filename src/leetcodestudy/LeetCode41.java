package leetcodestudy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode41 {
    public static void main(String[] args) {
        int[] num={1,7,8,9,11,12};
        List<Integer> numlist=new ArrayList<>();
        for(Integer i:num)
            numlist.add(i);
        int j=1;
        while(j<=numlist.size()){
            if (!numlist.contains(j))
                break;
            j++;
        }
        System.out.println(j);
    }
}
