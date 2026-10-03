class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) {
            return cost[0];
        }
        if (cost.length < 3) {
            return Math.min(cost[0], cost[1]);
        }
        int last = cost[cost.length - 1], secL = cost[cost.length - 2];
        // System.out.println("index: " + (cost.length - 2));
        // System.out.println("Last:" + last);
        System.out.println("Sec Last:" + secL);
        for (int i = cost.length - 3; i >= 0; i--) {
            int c = cost[i];
            int newCost = c + Math.min(secL, last);
            last = secL;
            secL = newCost;
            // System.out.println("index: " + i);
            // System.out.println("Last:" + last);
            // System.out.println("Sec Last:" + secL);
        }

        return Math.min(last, secL);
    }
}
