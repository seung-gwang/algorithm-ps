public class Solution {
    public int solution(int[][] board) {
        int row = board.length;
        int column = board[0].length;
        int[][] dp = new int[row][column];
        int maxSide = 0;

        for (int i = 0; i < row; i++) {
            dp[i][0] = board[i][0];
            maxSide = Math.max(maxSide, dp[i][0]);
        }
        
        for (int j = 0; j < column; j++) {
            dp[0][j] = board[0][j];
            maxSide = Math.max(maxSide, dp[0][j]);
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        
        return maxSide * maxSide;
    }
}
