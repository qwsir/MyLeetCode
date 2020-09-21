package leetcodestudy;

public class LeetCodeZeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZeroes(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] flag = new boolean[row][col];
        for(int i=0;i<row;i++)
            for (int j=0;j<col;j++){
                if(matrix[i][j] == 0)
                    flag[i][j] = true;
            }
        for(int i=0;i<row;i++)
            for (int j=0;j<col;j++){
                if(flag[i][j]){
                    int x = row;
                    int y = col;
                    while(x-->0){
                        matrix[x][j] = 0;
                    }
                    while(y-->0){
                        matrix[i][y] = 0;
                    }
                }
            }
    }
}
