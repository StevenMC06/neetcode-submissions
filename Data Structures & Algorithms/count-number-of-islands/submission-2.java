class Solution {
    // direcitons
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        
    // Get grid length row and cols
    int rows = grid.length, cols = grid[0].length;
    int islands = 0;

    for(int r = 0; r < rows; r++) {
        for(int c = 0; c< cols; c++) {
            if(grid[r][c] == '1') {
                bfs(grid, r,c);
                islands++;
            }
           
        }
    }

    return islands;
    // Create island count
    // Run loop on every every island appearance that aren't connected

    }

    // BFS method

    private void bfs(char[][] grid, int r, int c) {
        // Create a queue
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = '0';
        q.add(new int[]{r,c});
        // set the current node/grid value to 0 so we have seen it
        // Add this current island to the queue to check the next value

        // while loop
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for(int[] dir: directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.add(new int[]{nr,nc});
                    grid[nr][nc] = '0';
                }
            }
        }

            // pull the node
            // get the row and col values

            // run for each loop on directions to check all dir

                // check new row and new col if they are touching an existing 1 or make sure 
                // they are in range.



    }
}
