class Solution {
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        visited = new boolean[rows][cols];

        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == '1' && !visited[r][c]) {
                    bfs(r, c, grid);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int r, int c, char[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{r, c});
        visited[r][c] = true;

        int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        while (!q.isEmpty()) {
            int[] rc = q.poll();

            for (int[] node : dir) {

                int row = rc[0] + node[0];
                int col = rc[1] + node[1];

                if (row >= 0 && row < grid.length &&
                    col >= 0 && col < grid[0].length &&
                    grid[row][col] == '1' &&
                    !visited[row][col]) {

                    visited[row][col] = true;
                    q.offer(new int[]{row, col});
                }
            }
        }
    }
}