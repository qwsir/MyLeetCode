package leetcodestudy;

public class LeetCode130 {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
    }
    public static void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int row = board.length;
        int col = board[0].length;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(i == 0 || i == row-1 || j == 0 || j == col-1){
                    if (board[i][j] == 'O'){
                        dfs(board,i,j);
                    }
                }
            }
        }
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void dfs(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'A';
        dfs(board,i,j+1);
        dfs(board,i,j-1);
        dfs(board,i+1,j);
        dfs(board,i-1,j);
    }
}
