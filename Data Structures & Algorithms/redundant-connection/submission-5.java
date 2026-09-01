class Solution {
    int[] roots;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        roots = new int[n + 1];
        for (int i = 1; i <= n; i ++) {
            roots[i] = i;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[]{-1, -1};
    }

    private int find(int p) {
        if (p == roots[p]) return p;

        return roots[p] = find(roots[p]);
    }

    private boolean union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return false;

        roots[rootP] = rootQ;
        return true;
    }
}
