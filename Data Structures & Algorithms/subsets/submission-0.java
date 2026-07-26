class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(0, nums, subset, res);
        return res;
    }
    private void backtrack(int i, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));

            return;
        }
        // 1'st add this item;
        subset.add(nums[i]);
        backtrack(i + 1, nums,subset,res);
        // 2nd don't add this item;
    
            subset.removeLast();

        backtrack(i + 1, nums,subset,res);
    }
}
