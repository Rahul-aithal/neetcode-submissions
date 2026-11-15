class Solution {
    public boolean canPartition(int[] nums) {
        int s = sum(nums);
        if (s % 2 == 1)
            return false;
        int target = s / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int i = nums.length - 1; i >= 0; i--) {
            Set<Integer> ndp = new HashSet<>();
            for (int t : dp) {
                ndp.add(t + nums[i]);
                ndp.add(t);
                if (t + nums[i] == target)
                    return true;
            }
            dp = ndp;
        }
        return false;
    }
    public int sum(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        return s;
    }
}
