package leetcodestudy;

import java.util.HashSet;

public class LeetCodeWordDistance {
    public static void main(String[] args) {
        String[] words = {"I","am","a","student","from","a","university","in","a","city"};
        String word1 = "a";
        String word2 = "student";
        System.out.println(findClosest(words,word1,word2));
    }
    public static int findClosest(String[] words, String word1, String word2) {
        if(word1 == word2){
            return 0;
        }
        HashSet<String> set = new HashSet<String>(){{add(word1);add(word2);}};
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                left = i;
            }
            if(words[i].equals(word2)){
                right = i;
            }
            if(words[left].equals(word1)&words[right].equals(word2)){
                int temp = Math.abs(left - right);
                minLen = Math.min(minLen,temp);
            }
        }
        return minLen;
    }
}
