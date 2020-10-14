package leetcodestudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LeetCodeOffer45 {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(minNumber(nums));
    }
    //1. 将num中的数字转为字符串同时两两比较这个两个字符串相互拼接的大小
    //2. 最终得到一个数字字符串从小到大的序列
    public static String minNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";
        ArrayList<String> list = new ArrayList<>();
        for(int num : nums)
            list.add(String.valueOf(num));
        Collections.sort(list, (o1, o2) -> (o1+""+o2).compareTo(o2+""+o1));
        StringBuilder newString = new StringBuilder();
        for(String temp : list)
            newString.append(temp);
        return newString.toString();
    }

}
