package leetcodestudy;

import java.util.HashMap;

public class LeetCode76 {
    public static void main(String[] args) {
       String S = "ADOBECODEBANC", T = "ABC";
       System.out.println(minWindow(S,T));
    }
    public static String minWindow(String s, String t) {
        int left=0, right=0;
        int min_len=Integer.MAX_VALUE;   //用于判断符合条件的子串的最小长度
        String minStr="";                //记录最小子串

        //记录每个字符出现的次数，并用于判断是否包含子串
        HashMap<Character, Integer> map = new HashMap<>();
        char[] t_char = t.toCharArray();
        for(Character c: t_char){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        while(right<s.length()){
            char temps=s.charAt(right);
            //判断map中是否包含该字符
            if (map.containsKey(temps)){
                map.put(temps,map.get(temps)-1);
                //判断是否包含子串
                while(judgeStr(map)){
                    int temp_len=right-left+1;
                    if(min_len>temp_len){   //得到最小子串
                        minStr=s.substring(left,right+1);
                        min_len=temp_len;
                    }
                    //之后需要移动左指针
                    char left_char=s.charAt(left);
                    if (map.containsKey(left_char)){
                        //移除当前字母
                        map.put(left_char,map.get(left_char)+1);
                    }
                    left++;
                }
            }
            right++;
        }
        return minStr;
    }
    public static boolean judgeStr(HashMap<Character,Integer> map){
        for(Integer count: map.values()){
            if (count>0)
                return false;
        }
        return true;
    }
}
