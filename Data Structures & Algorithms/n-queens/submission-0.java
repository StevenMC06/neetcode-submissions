class Solution {
    List<List<String>> res = new ArrayList<>();
    int n;
    char[][] board;

    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        // create empty board
        board = new char[n][n];

        for(int r = 0; r < n; r++) {
            Arrays.fill(board[r], '.');
        }
        dfs(0);

        return res; 

    }

    private void dfs(int row) {
        if(row == n) {
            List<String> solution = new ArrayList<>();
            for(int r = 0; r < n; r++) {
                solution.add(new String(board[r]));
            }
            res.add(solution);
            return;
        }

        for(int col = 0; col < n; col++) {
            if(cols.contains(col) || posDiag.contains(row+col) || negDiag.contains(row-col)) {
                continue;
            }

            board[row][col] = 'Q';
            cols.add(col);
            posDiag.add(row+col);
            negDiag.add(row-col);

            dfs(row+1);

            board[row][col] = '.';
            cols.remove(col);
            posDiag.remove(row+col);
            negDiag.remove(row-col);

        }
    }
}
