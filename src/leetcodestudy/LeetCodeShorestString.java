package leetcodestudy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LeetCodeShorestString {
    public static void main(String[] args) {
        int[] big = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
        int[] small = {1,5,9};
        int[] num = shortestSeq(big, small);
        if(num != null){
           System.out.println(num[0]+"\t"+num[1]);
        }
    }
    //1. 用set存储small数组中的元素。map用来存储big数组中包含了small中元素及其下标
    //2. 若map中包含set中的所有元素，则用当前索引减去map元素中的最小索引
    //3. 若此时长度为最小，更新left和right的下标，同时更新长度。
    public static int[] shortestSeq(int[] big, int[] small) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : small)
            set.add(num);
        int len = Integer.MAX_VALUE, right = 0, left = 0, index =0;
        while(index < big.length){
            int num = big[index];
            if(set.contains(num)){
                map.put(num, index);
                if(map.size() == set.size()){
                    int curLen = index - getMinIndex(map)+1;
                    if(len > curLen){
                        left = getMinIndex(map);
                        right = index;
                        len = right - left + 1;
                    }
                }
            }
            index++;
        }
        if(left == 0 && right == 0)
            return new int[]{};
        else return new int[]{left,right};
    }
    public static int getMinIndex(HashMap<Integer,Integer> map){
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> temp : map.entrySet()){
            min = Math.min(temp.getValue(),min);
        }
        return min;
    }
}
