package leetcodestudy;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeString {
    public static void main(String[] args) {
        String s = "abcaebfcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxlen = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0,j=0;j<len;j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            maxlen = Math.max(maxlen,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return maxlen;
    }
}
