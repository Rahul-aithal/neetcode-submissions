class Solution {
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int swimInWater(int[][] grid) {
        int ROW = grid.length, COL = grid[0].length;
        int[][] path = new int[ROW][COL];
        int destination = grid[ROW - 1][COL - 1];
        for (int[] row : path) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Set<Integer> visited = new HashSet<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[] {grid[0][0], 0, 0});
        while (!minHeap.isEmpty()) {
            int[] minValue = minHeap.poll();
            if (minValue[1] == ROW - 1 && minValue[2] == COL - 1) {
                return minValue[0];
                            }
            for (int[] dir : directions) {
                int nr = minValue[1] + dir[0], nc = minValue[2] + dir[1];
                if (nr > ROW - 1 || nc > COL - 1 || nr < 0 || nc < 0)
                    continue;
                int val = grid[nr][nc];
                int gt = Math.max(val, minValue[0]);
                if (path[nr][nc] > gt) {
                    path[nr][nc] = gt;
                    minHeap.offer(new int[] {gt, nr, nc});
                }
            }
        }

        return path[ROW - 1][COL - 1];
    }
}
