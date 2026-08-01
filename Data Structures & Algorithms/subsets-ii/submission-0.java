class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res.add(new ArrayList());
        backtrack(0, nums, new ArrayList<>());
        return res;
    }
    public void backtrack(int curr, int[] nums, List<Integer> arr) {
        if (curr >= nums.length)
            return;

        // System.out.println(curr);
        // System.out.println(res);

        // System.out.println(arr);
        arr.add(nums[curr]);

        res.add(new ArrayList(arr));
        // With curr
        backtrack(curr + 1, nums, arr);

        arr.removeLast();
        while (curr < nums.length - 1 && nums[curr] == nums[curr + 1]) {
            curr++;
        }
        backtrack(curr + 1, nums, arr);
    }
}
