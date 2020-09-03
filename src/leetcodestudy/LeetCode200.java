package leetcodestudy;

public class LeetCode200 {
    public static void main(String[] args) {
        char[][] arr = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };
        System.out.println(numIslands(arr));
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        if(grid==null||m==0){
            return 0;
        }
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if (grid[i][j]=='1'){   //发现岛屿，对周边进行深度优先遍历
                    judgeIsLand(grid,i,j);
                    count++;           //只要发现一个1，则必然存在一个相关岛屿
                }
            }
        return count;
    }
    public static void judgeIsLand(char[][] map, int i, int j){
        if(i>=map.length||j>=map[0].length||i<0||j<0||map[i][j]=='0'){  //碰到上下左右任何一个边界，则该方向的递归结束
            return;
        }
        //将每个岛屿都置为海水
        map[i][j] = '0';
        //分别从四个方向进行深度优先遍历，不用关注顺序
        judgeIsLand(map,i+1,j);
        judgeIsLand(map,i-1,j);
        judgeIsLand(map,i,j+1);
        judgeIsLand(map,i,j-1);
    }
}
