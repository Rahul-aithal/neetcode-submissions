class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();

        for (int[] time : times) {
            map.computeIfAbsent(time[0], key -> new ArrayList<>())
                .add(new int[] {time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt((a) -> a[1]));
        minHeap.offer(new int[] {k, 0});
        int t = 0;
        HashSet<Integer> visited = new HashSet<>();
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int n1 = curr[0];
            int w1 = curr[1];
            if (visited.contains(n1))
                continue;
            t = Math.max(w1, t);
            visited.add(n1);
            if (!map.containsKey(n1))
                continue;
            for (int[] next : map.get(n1)) {
                int n2 = next[0];
                int w2 = next[1];
                if (!visited.contains(n2)) {
                    minHeap.offer(new int[] {n2, w1 + w2});
                }
            }
        }
        return visited.size() == n ? t : -1;
    }
}
