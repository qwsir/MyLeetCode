package leetcodestudy;

public class LeetCodeKNum {
    public static void main(String[] args) {
        int k = 5;
        System.out.println(getKthMagicNumber(k));
    }
    //面试题 17.09. 第 k 个数
    public static int getKthMagicNumber(int k) {
        int index3 = 0;
        int index5 = 0;
        int index7 = 0;
        int[] res = new int[k];
        res[0] = 1;
        for(int i = 1;i < k;i++){
            int num3 = 3*res[index3];
            int num5 = 5*res[index5];
            int num7 = 7*res[index7];
            res[i] = Math.min(Math.min(num3,num5),num7);
            if(res[i] == num3) index3++;
            if(res[i] == num5) index5++;
            if(res[i] == num7) index7++;
        }
        return res[k-1];
    }
}
