package leetcodestudy;

public class LeetCode547 {
    public static void main(String[] args) {
        int[][] M = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(findCircleNum(M));
    }
    public static int findCircleNum(int[][] M) {
        int[] visit = new int[M.length];
        int count = 0;
        for(int i = 0;i < M.length;i++){
            //是否访问过这个人的朋友圈
            if(visit[i] == 0){
                dfs(M,visit,i);
                count++;
            }
        }
        return count;
    }
    public static void dfs(int[][] M,int[] visit,int i){
        visit[i] = 1;
        //遍历当前这个人的朋友圈
        for(int j = 0;j < M.length;j++){
            if(visit[j] == 0 && M[i][j] == 1){
                dfs(M,visit,j);
            }
        }
    }

}
