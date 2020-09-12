package leetcodestudy;

public class LeetCode79 {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String str = "ABCB";
        System.out.println(exist(board,str));
    }
    public static boolean exist(char[][] board, String word) {
        char[] myword = word.toCharArray();
        boolean flag = false;
        int row = board.length;
        int col = board[0].length;
        int[][] change={{0,1},{1,0},{0,-1},{-1,0}};
        if (word.length()==0||board.length==0||board[0].length==0)
            return flag;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(board[i][j] == myword[0]){
                    flag = dfs(board,i,j,myword,0,change);
                    if(flag) return flag;
                }
            }
        }
        return flag;
    }
    //深度优先遍历矩阵
    public static boolean dfs(char[][] board,int i,int j,char[] myword, int start,int[][] change){
        char c = board[i][j];
        if(myword[start]!=c)  //存在任意字符不匹配，不存在该单词
            return false;
        if(start == myword.length-1)   //匹配所有字符，存在该单词
            return true;
        //匹配字符中
        board[i][j] = '#';    //代表该字符符合要求，'#'表示已经访问过。
        for(int direct = 0;direct < 4;direct++){    //表示上下左右四个方向
            int indexi = i + change[direct][0];
            int indexj = j + change[direct][1];
            //边界判定
            if(indexi>=0&&indexi<board.length&&indexj>=0&&indexj<board[0].length&&board[indexi][indexj]!='#'){
                if(dfs(board,indexi,indexj,myword,start+1,change))
                    return true;
            }
        }
        board[i][j] = c;
        return false;
    }
}
