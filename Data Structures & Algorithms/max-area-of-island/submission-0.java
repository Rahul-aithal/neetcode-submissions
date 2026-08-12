class Solution {
    final int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if (grid == null) {
            return maxArea;
        }

        int ROWS = grid.length;
        int COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    int area = bfs(r, c, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public int bfs(int r, int c, int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = 0;
        q.offer(new int[] {r, c});
        int area = 1;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];

            for (int[] dir : directions) {
                int nc = col + dir[1];
                int nr = row + dir[0];

                if ((nc >= 0 && nr >= 0) && (nr < grid.length && nc < grid[0].length)
                    && (grid[nr][nc] == 1)) {
                    grid[nr][nc] = 0;
                    q.offer(new int[] {nr, nc});
                    area++;
                }
            }
        }
        return area;
    }
}
