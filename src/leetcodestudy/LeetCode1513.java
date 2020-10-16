package leetcodestudy;

public class LeetCode1513 {
    public static void main(String[] args) {
        String s = "101101111110101011101111111111110111111";
        System.out.println(numSub(s));
    }
    public static int numSub(String s) {
        int res = 0;
        for(int i = 0;i < s.length();i++){
            int count = 0;
            int sum = 0;
            while(i < s.length() && s.charAt(i) == '1'){
                count++;
                sum += count;
                sum = sum%(10_0000_0000+7);
                i++;
            }
            res += sum;
        }
        return res;
    }

}
