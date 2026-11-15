class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        this.dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dfs(i, nums));
        }
        return max;
    }
    public int dfs(int i, int[] nums) {
        if (nums.length <= i) {
            return 0;
        }
        if (dp[i] != Integer.MIN_VALUE)
            return dp[i];
        int max = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                max = Math.max(max, 1 + dfs(j, nums));
            }
        }
        dp[i] = max;
        // System.out.println(nums[i] + " " + dp[i]);
        return max;
    }
}
