class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        int rob1 = 0;
        int rob2 = 0;
        for (int i : nums){
            int temp = Math.max(rob1+i,rob2);
            rob1 = rob2;
            rob2=temp;
        }
    return rob2;
    }
}
