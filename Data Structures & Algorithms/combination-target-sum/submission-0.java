class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> subset = new ArrayList<>();
        backtrack(0,nums,subset,target);
        return res;
    }
    public void backtrack(int i, int[]nums,List<Integer> subset,int target){
        if(target==0) {
                this.res.add(new ArrayList<>(subset));
            
            return;
        }
        if(i>=nums.length|| target < 0){
            return;
        }
        //Include Condition;
        subset.add(nums[i]);
        backtrack(i,nums,subset,target-subset.getLast());

        //Exclude Condition:
        subset.removeLast();
        backtrack(i+1,nums,subset,target);

    }
 
}
