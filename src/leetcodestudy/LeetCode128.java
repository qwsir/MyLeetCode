package leetcodestudy;


import java.util.HashMap;

public class LeetCode128 {
    public static void main(String[] args) {
        int[] array={1,2,0,1,3,7,-1,8,9,10,11,12,13};
        System.out.println(longestConsecutive(array));
    }
    /**
     1. 第一思路是排序后遍历数组即可，但排序最快为O(log(n)),不符合题意，见解法二
     2. 遍历数组，使用map来存储数据，其中key值为元素值，value为包含该元素的序列长度。
     即从序列头部或尾部到该元素的长度。
     **/
    public static int longestConsecutive(int[] nums) {
        //解法一
        if(nums.length==0||nums==null)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                //分别记录左右两边的长度
                int left=0,right=0;
                if(map.containsKey(nums[i]-1)){  // 向左进行遍历，记录左边长度
                    int lefti=nums[i]-1;
                    while(map.containsKey(lefti)){
                        left++;
                        lefti--;
                    }
                }
                else
                    left=0;
                if(map.containsKey(nums[i]+1)){  //向右进行遍历，记录右边长度
                    int righti=nums[i]+1;
                    while(map.containsKey(righti)){
                        right++;
                        righti++;
                    }
                }
                else
                    right=0;
                max=Math.max(max,left+right+1);
                map.put(nums[i],1);
            }
        }
        return max;
       /* 解法二
        if(nums.length==0||nums==null)
            return 0;
        Arrays.sort(nums);
        for (int i:nums)
            System.out.println(i);
        int len=1;
        int count=1;
        for (int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]-1){
                count++;
            }
            else if(nums[i]==nums[i+1]){
                continue;
            }
            else{
                len=Math.max(len,count);
                count=1;
            }

        }
        return Math.max(len,count);
    }
        **/
    }
}
