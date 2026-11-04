class Solution {
    public int rob(int[] nums) {
        int last = nums[nums.length - 1];
        nums[nums.length - 1] = 0;
        int r1 = rob1(nums);
        nums[0] = 0;
        nums[nums.length - 1] = last;

        return Math.max(r1, rob1(nums));
    }
    public int rob1(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        for (int i : nums) {
            int temp = Math.max(rob1 + i, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
