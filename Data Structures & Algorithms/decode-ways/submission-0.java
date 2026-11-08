class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
            }

            if (i < s.length() -1 && isValid(i, s)) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
    public boolean isValid(int i, String s) {
        if (s.charAt(i) == '1')
            return true;
        if (s.charAt(i) == '2' && s.charAt(i + 1) - '0' <= 6 && s.charAt(i + 1) - '0' >= 0)
            return true;
        return false;
    }
}
