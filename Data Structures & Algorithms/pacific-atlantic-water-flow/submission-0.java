class Solution {
    private static final int[][] directions = {{1,0}, {0,1}, {-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols]; 
        boolean[][] atl = new boolean[rows][cols];

        // Top and bottom borders
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pac);
            dfs(heights, rows-1, c, atl);

        }

        // Left and Right 
        for(int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pac);
            dfs(heights, r, cols-1, atl);
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if (pac[r][c] && atl[r][c]) {
                    result.add(Arrays.asList(r,c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for(int[] dir: directions) {
            int nr = r + dir[0];
            int nc = c + dir[1]; 

            if(
                nr < 0 || nr >= heights.length || nc < 0 || nc >=heights[0].length|| visited[nr][nc] || heights[nr][nc] < heights[r][c]
            ) {
                continue;
            }

            dfs(heights,nr, nc, visited);
        }
    }
}
