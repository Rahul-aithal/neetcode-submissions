class Solution {
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        int[][] pac = new int[ROWS][COLS];
        int[][] atl = new int[ROWS][COLS];

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, heights);
            dfs(ROWS - 1, c, atl, heights);
        }
        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, COLS - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] == 1 && atl[r][c] == 1) {
                    List<Integer> cord = new ArrayList<>();
                    cord.add(r);
                    cord.add(c);
                    res.add(cord);
                }
            }
        }
        return res;
    }

    public void dfs(int r, int c, int[][] visited, int[][] heights) {
        visited[r][c] = 1;
        int ROWS = heights.length, COLS = heights[0].length;

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if ((nc < 0 || nr < 0) || (nr >= ROWS || nc >= COLS) || (visited[nr][nc] == 1)|| (heights[r][c] > heights[nr][nc])) {
                continue;
            }
            dfs(nr, nc, visited, heights);
        }
    }
}
