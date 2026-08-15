class Solution {
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    // int[][] visted;
    public int orangesRotting(int[][] grid) {
        if (grid == null)
            return -1;
        int ROWS = grid.length, COLS = grid[0].length;
        // visted = new int[ROWS][COLS];
        Queue<int[]> rotten = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    rotten.offer(new int[] {i, j});
                }
            }
        }
        int rottenFound = rotten.size();
        int minute = 0;

        while (fresh > 0 && !rotten.isEmpty()) {
            int length = rotten.size();
            for (int i = 0; i < length; i++) {
                int[] rc = rotten.poll();

                for (int[] dir : directions) {
                    int r = rc[0] + dir[0];
                    int c = rc[1] + dir[1];
                    if (!validRC(r, c, grid)) {
                        continue;
                    }
                    grid[r][c] = 2;
                    rotten.offer(new int[] {r, c});
                    fresh--;
                }
            }
            minute++;
        }

        return fresh == 0 ? minute : -1;
    }

    public boolean validRC(int i, int j, int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;

        if ((i < 0 || j < 0) || (i >= ROWS || j >= COLS) || (grid[i][j] != 1)) {
            return false;
        }
        return true;
    }
}
