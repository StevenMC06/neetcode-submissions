class Solution {
    private static final int[][] direction = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int islands = 0;

        for(int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(grid[r][c] == '1') {
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        grid[r][c] = '0'; 
        queue.add(new int[]{r,c});

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];

            for(int[] dir: direction) {
                int nr = row + dir[0];
                int nc = col + dir[1];
            

                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1'){
                    queue.add(new int[]{nr,nc});
                    grid[nr][nc] = '0';
                }
                
            }
        }
    }
}
