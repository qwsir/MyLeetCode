package leetcodestudy;

import java.util.HashMap;

public class LeetCode1 {
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
        int[] index=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if (map.containsKey(temp)){
                index[0]=map.get(temp);
                index[1]=i;
                System.out.println(index[0]+":"+index[1]);
            }
            map.put(nums[i],i);
        }
    }
}
