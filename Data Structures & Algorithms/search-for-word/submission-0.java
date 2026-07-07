class Solution {
    char[][] board;
    String word;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.visited = new boolean[board.length][board[0].length];

        for(int r=0; r < board.length; r++) {
            for (int c = 0; c < board[0].length;c++){
                if(dfs(r,c,0)) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean dfs(int r, int c, int index) {
        if(index == word.length()) {
            return true;
        }

        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return false;
        }

        if(visited[r][c]) {
            return false;
        }

        if(board[r][c]!= word.charAt(index)) {
            return false;
        }

        visited[r][c] = true;

        boolean found =
        dfs(r + 1, c, index + 1) ||
        dfs(r - 1, c, index + 1) ||
        dfs(r, c + 1, index + 1) ||
        dfs(r, c - 1, index + 1);

        visited[r][c] = false;

        return found;

    }
}
