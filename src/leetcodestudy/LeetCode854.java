package leetcodestudy;

public class LeetCode854 {
    int minSwap = Integer.MAX_VALUE;
    public static void main(String[] args) {
        String A = "";
        String B = "";
        System.out.println(new LeetCode854().kSimilarity(A,B));
    }
    //解题思路 https://leetcode-cn.com/problems/k-similar-strings/solution/cu-su-yi-dong-di-gui-hui-su-si-lu-by-tuo-jiang-de-/
    public int kSimilarity(String A, String B) {
        int len = A.length();
        char[] listA = A.toCharArray();
        char[] listB = B.toCharArray();
        doSwap(listA,listB,len,0,0);
        return minSwap;
    }
    public void  doSwap(char[] listA, char[] listB, int len, int curCount, int curIndex){
        if(minSwap < curCount) // 当前次数已经超过当前最小次数，则直接返回不必要进行递归了
            return;
        if(curIndex == len -1){
            if(curCount < minSwap){
                minSwap = curCount;
            }
            return;
        }
        int i = curIndex;
        for(;i < len;i++){
            if (listA[i] == listB[i])  //元素相等则遍历下一个
                continue;
            //不相等，则从listB的后续字符中查找与listA中相等的字符进行替换
            char atempChar = listA[i];
            int k = i+1;
            for(;k < len;k++){
                if(atempChar == listB[k]){
                    swap(listB,i,k);
                    doSwap(listA,listB,len,curCount+1,i+1);
                    swap(listB,i,k);
                }
            }
            return;
        }
        if(i == len){
            if(curCount < minSwap)
                minSwap = curCount;
        }
    }
    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
