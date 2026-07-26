class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
   List<Integer> subset = new ArrayList<>();
   Arrays.sort(candidates);
        backtrack(0,candidates,subset,target);
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
        backtrack(i+1,nums,subset,target-subset.getLast());

        //Exclude Condition:
        while(i<nums.length-1&&nums[i]==nums[i+1]) i++;
        subset.removeLast();
        backtrack(i+1,nums,subset,target);

    }
}
