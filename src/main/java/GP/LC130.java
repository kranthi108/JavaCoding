package GP;
// 130 ..... surrounded regions
//You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
//
//        Connect: A cell is connected to adjacent cells horizontally or vertically.
//        Region: To form a region connect every 'O' cell.
//        Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
//        A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.
public class LC130 {
    public static void solve(char[][] board) {
        if(board == null || board.length == 0)
            return;
        int rows = board.length;
        int columns = board[0].length;
        for(int i=0; i<rows; i++) {
            if(board[i][0] == 'O')
                dfs(board, i, 0);
            if(board[i][columns-1] == 'O')
                dfs(board, i, columns-1);
        }
        for(int j=0; j<columns; j++) {
            if(board[0][j] == 'O')
                dfs(board, 0, j);
            if(board[rows-1][j] == 'O')
                dfs(board, rows-1, j);
        }
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private static void dfs(char[][] board, int i, int j) {
        if(i<0 || i>=board.length || j<0 || j >= board[0].length || board[i][j] != 'O')
            return;
        board[i][j] = 'T';
        dfs(board, i, j+1);
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j-1);
    }
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        for (char[] row : board) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
