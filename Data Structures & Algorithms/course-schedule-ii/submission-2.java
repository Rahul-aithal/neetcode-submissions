class Solution {
    Set<Integer> completed = new HashSet<>();
    int[] order;
    int orderIndx = 0;
    int[] visited;
    Map<Integer, List<Integer>> mapPQ;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int pl = prerequisites.length;
        this.visited = new int[numCourses];
        this.mapPQ = new HashMap<>();
        this.order = new int[numCourses];

        for (int i = 0; i < pl; i++) {
            mapPQ.put(prerequisites[i][0], new ArrayList<>());
        }
        for (int i = 0; i < pl; i++) {
            List<Integer> req = mapPQ.get(prerequisites[i][0]);
            req.add(prerequisites[i][1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (completed.contains(c))
                continue;
            if (!add(c, prerequisites)) {
                return new int[0];
            };
        }
        return order;
    }

    public boolean add(int c, int[][] pq) {
        if (completed.contains(c))
            return true;
        if (visited[c] == 1)
            return false;
        List<Integer> req = mapPQ.get(c);
        visited[c] = 1;
        if (req != null) {
            for (int r : req) {
                if (!add(r, pq)) {
                    return false;
                }
            }
        }
        completed.add(c);
        order[orderIndx++] = c;
        return true;
    }
}
