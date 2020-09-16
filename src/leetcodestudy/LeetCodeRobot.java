package leetcodestudy;

public class LeetCodeRobot {
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int k = 1;
        System.out.println(movingCount(m,n,k));
    }
    public static int movingCount(int m, int n, int k) {
        //定义二维数组代表能访问的位置
        boolean[][] visit = new boolean[m][n];
        return dfsVisit(visit,0,0,m,n,k);
    }
    //题目限定了m和n的范围为1-100，可以用m%10,m/10表示十位和个位
    public static int dfsVisit(boolean[][] visit,int i,int j,int m,int n,int k){
        //符合条件且未访问过
        if(i<m && j<n && (i/10+i%10+j/10+j%10)<=k && !visit[i][j]){
            visit[i][j] = true;
            return 1+dfsVisit(visit,i+1,j,m,n,k)+dfsVisit(visit,i,j+1,m,n,k);
        }
        else return 0;
    }
}
