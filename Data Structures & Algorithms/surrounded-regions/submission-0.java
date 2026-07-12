class Solution {
    private static final int[][] directions = {{1,0},{-1,0}, {0,1}, {0,-1}};
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

       for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c, visited);
            }

            if (board[rows - 1][c] == 'O') {
                dfs(board, rows - 1, c, visited);
            }
        }

        // left and right
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0, visited);
            }

            if (board[r][cols - 1] == 'O') {
                dfs(board, r, cols - 1, visited);
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O' && !visited[r][c]) {
                    board[r][c] = 'X';
                }
            }
    }
        
    }

    private void dfs(char[][] board, int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for(int[] dir: directions) {
            int nr = r + dir[0], nc = c + dir[1];

            if(nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length || visited[nr][nc] == true || board[nr][nc] != 'O') {
                continue;
            }

            dfs(board, nr,nc, visited);
        }
    }
}
