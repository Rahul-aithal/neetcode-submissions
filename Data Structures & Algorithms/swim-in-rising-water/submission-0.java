class Solution {
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int swimInWater(int[][] grid) {
        int ROW = grid.length, COL = grid[0].length;
        int[][] path = new int[ROW][COL];
        int destination = grid[ROW - 1][COL - 1];
        for (int[] row : path) {
            Arrays.fill(row, 0);
        }
        Set<Integer> visited = new HashSet<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[] {grid[0][0], 0, 0});
        while (!minHeap.isEmpty()) {
            int[] minValue = minHeap.poll();
            if (visited.contains(minValue[0])) {
                continue;
            }
            visited.add(minValue[0]);
            for (int[] dir : directions) {
                int nr = minValue[1] + dir[0], nc = minValue[2] + dir[1];
                if (nr > ROW - 1 || nc > COL - 1 || nr < 0 || nc < 0)
                    continue;
                int val = grid[nr][nc];
                if (!visited.contains(val)) {
                    int gt = Math.max(val, Math.max(path[minValue[1]][minValue[2]], minValue[0]));
                    path[nr][nc] = -Math.min(path[nr][nc], -gt);
                    if (val == destination)
                        return path[ROW - 1][COL - 1];
                    minHeap.offer(new int[] {val, nr, nc});
                }
            }
        }

        return path[ROW - 1][COL - 1];
    }
}
