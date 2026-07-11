class Solution {
    private static final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 2) {
                    q.add(new int[]{r,c});
                }
            }
        }
        int mins = bfs(grid, q);

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return mins;
    }

    private int bfs(int[][] grid, Queue<int[]> q) {
        int mins = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            boolean rottenFruit = false; 

            for(int i = 0; i < size; i++) {
                int[] node = q.poll();
                int row = node[0], col = node[1];

                for(int[] dir: directions) {
                    int nr = row + dir[0], nc = col + dir[1];
                    if(nr < 0 || nc < 0 || nr > grid.length -1 || nc > grid[0].length-1 || grid[nr][nc] != 1) {
                        continue;
                    }
                    q.add(new int[]{nr,nc});
                    grid[nr][nc] = 2; 
                    rottenFruit = true;
                }
            }
            if(rottenFruit) {
                mins++;
            }
           
        } 
        return mins;
    }
}
