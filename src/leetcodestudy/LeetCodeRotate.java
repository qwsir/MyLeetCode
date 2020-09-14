package leetcodestudy;

public class LeetCodeRotate {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++)
                System.out.print(matrix[i][j]+"\t");
            System.out.println();
        }
    }
    /**
     * 1.需要先上下翻转，即上下交换
     * 2.然后按照从左上到右下的对角线相互交换
     */
    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0;i<row/2;i++){
            for(int j=0;j<col;j++){
                matrix[i][j] = matrix[i][j]^matrix[row-i-1][j];
                matrix[row-i-1][j] = matrix[i][j]^matrix[row-i-1][j];
                matrix[i][j] = matrix[i][j]^matrix[row-i-1][j];
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<i;j++){
                matrix[i][j] = matrix[i][j]^matrix[j][i];
                matrix[j][i] = matrix[i][j]^matrix[j][i];
                matrix[i][j] = matrix[i][j]^matrix[j][i];
            }
        }
    }
}
