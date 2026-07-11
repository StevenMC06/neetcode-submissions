class Solution {
    private static final int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    
    public void islandsAndTreasure(int[][] grid) {

        int row = grid.length, col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                if(grid[r][c] ==0) {
                    q.add(new int[]{r,c});
                }
            }
        }
        
        bfs(grid,q);
    }

    private void bfs(int[][]grid, Queue<int[]> q){
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                // process one node
                int[] node = q.poll();
                int row = node[0], col = node[1]; 
                
                // visit its neighbors
                for(int[] dir: directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if(nr < 0 || nr > grid.length-1 || nc < 0 || nc > grid[0].length-1 || grid[nr][nc] != 2147483647 || grid[nr][nc] == -1 ) {
                        continue;
                    }
                    grid[nr][nc] = grid[row][col] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        
    }
}
