package leetcodestudy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {

    public static void main(String[] args) {
        int[] nums = {2,5,7,8};
        List<List<Integer>> permute = permute(nums);
        for(List<Integer> temp : permute)
            System.out.println(temp);

    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,nums,0);
        return res;
    }
    public static void dfs(List<List<Integer>> res,int[] nums,int start){
        //递归结束的终点
        if(start == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num: nums)
                list.add(num);
            res.add(list);
        }
        else{
            for(int i = start;i<nums.length;i++){
                swap(nums,i,start);
                dfs(res,nums,start+1);
                swap(nums,i,start);
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
