class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        Arrays.sort(coins);

        if (coins[0] > amount) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];

                if (i > coin) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                } else if (i == coin) {
                    dp[i] = 1;
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
