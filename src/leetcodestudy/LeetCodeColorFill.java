package leetcodestudy;

public class LeetCodeColorFill {
    public static void main(String[] args) {
        int[][] image = {
//                {1,1,1},
//                {1,1,0},
//                {1,0,1}
                {0,0,0},
                {0,1,1}
        };
        int[][] array = floodFill(image, 1, 1, 1);
        for(int i = 0;i < array.length;i++){
            for(int j = 0;j < array[0].length;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        dfs(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
    public static void dfs(int[][] image,int sr,int sc,int newColor,int oldColor){
        int row = image.length;
        int col = image[0].length;
        if(sr<0 || sr>=row || sc<0 || sc>=col || image[sr][sc] != oldColor){
            return ;
        }
        if(image[sr][sc] == oldColor){
            image[sr][sc] = newColor;
        }
        dfs(image,sr+1,sc,newColor,oldColor);
        dfs(image,sr-1,sc,newColor,oldColor);
        dfs(image,sr,sc+1,newColor,oldColor);
        dfs(image,sr,sc-1,newColor,oldColor);
    }

}
