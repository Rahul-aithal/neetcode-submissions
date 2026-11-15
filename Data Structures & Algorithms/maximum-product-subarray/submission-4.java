class Solution {
    public int maxProduct(int[] nums) {
        int res = Arrays.stream(nums).max().getAsInt();
        int curMax = 1, curMin = 1;

        for (int i : nums) {
            if (i == 0) {
                curMax = 1;
                curMin = 1;
                continue;
            }
            int tem = curMax * i;
            curMax = Math.max(i, Math.max(tem, curMin * i));
            curMin = Math.min(i, Math.min(tem, curMin * i));
            res = Math.max(curMax,res);
        }
        return res;
    }
}
