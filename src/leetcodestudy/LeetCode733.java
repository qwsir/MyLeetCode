package leetcodestudy;

public class LeetCode733 {
    public static void main(String[] args) {
        int[][] image = {{0,0,0},{0,1,1}};
        floodFill(image,1,1,1);
        for (int i = 0;i < image.length;i++){
            for (int j = 0;j < image[0].length;j++)
                System.out.print(image[i][j] + "\t");
            System.out.println();
        }

    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (newColor == image[sr][sc])
            return image;
        dfs(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
    public static void dfs(int[][] image,int sr,int sc,int newColor,int originalColor){
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != originalColor)
            return ;
        image[sr][sc] = newColor;
        dfs(image,sr+1,sc,newColor,originalColor);
        dfs(image,sr-1,sc,newColor,originalColor);
        dfs(image,sr,sc+1,newColor,originalColor);
        dfs(image,sr,sc-1,newColor,originalColor);
        return ;
    }
}
