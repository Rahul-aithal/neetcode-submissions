class Solution {
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || n == 0 || n==1)
            return true;

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
        boolean noCycle = dfs(edges[0][0], -1);
        return noCycle && visited.size() == n;
    }
    public boolean dfs(int curr, int prev) {
        if (visited.contains(curr)) {
            return false;
        }
        visited.add(curr);
        for (int edge : adj.get(curr)) {
            if (edge == prev)
                continue;

            boolean nonCyclic = dfs(edge, curr);
            if (!nonCyclic)
                return false;
        }
        return true;
    }
}
