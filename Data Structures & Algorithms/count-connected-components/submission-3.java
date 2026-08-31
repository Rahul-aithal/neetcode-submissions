class Solution {
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    boolean[] visited;
    public int countComponents(int n, int[][] edges) {
        if (edges == null || n == 0 || n == 1)
            return 1;
        visited = new boolean[n];
        for (int[] edge : edges) {
            if (!adj.containsKey(edge[0])) {
                adj.put(edge[0], new ArrayList<Integer>());
            }
            if (!adj.containsKey(edge[1])) {
                adj.put(edge[1], new ArrayList<Integer>());
            }
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1);
                count++;
            }
        }
        return count;
    }

    public void dfs(int curr, int prev) {
        if (!adj.containsKey(curr))
            return;
        if (visited[curr]) {
            return;
        }
        visited[curr] = true;
        System.out.println(curr);
        for (int edge : adj.get(curr)) {
            if (edge == prev)
                continue;
            if (visited[edge]) {
                continue;
            }
            dfs(edge, curr);
        }
    }
}
