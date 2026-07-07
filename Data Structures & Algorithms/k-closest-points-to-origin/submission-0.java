class Solution {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(points.length,(a, b) -> {
            int ax = a[0] - 0;
            int ay = a[1] - 0;
            double dista = Math.sqrt((ax * ax) + (ay * ay));
            int bx = b[0] - 0;
            int by = b[1] - 0;
            double distb = Math.sqrt((bx * bx) + (by * by));
           return Double.compare(dista,distb);
        });
        int[][] res = new int[k][2];
        for (int[] point : points) {
            minHeap.offer(point);
        }

        for (int i = 0; i < k; i++) {
            int[] point = minHeap.poll();
            res[i][0] = point[0];
            res[i][1] = point[1];
        }
        return res;
    }
}
