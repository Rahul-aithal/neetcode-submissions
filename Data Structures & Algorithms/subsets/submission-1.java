class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        get_sets(nums,0,new ArrayList<>());
        return res;
    }
    void get_sets(int[] nums,int idx,List<Integer> ans){
        res.add(new ArrayList(ans));
        for(int i=idx;i<nums.length;i++){
            ans.add(nums[i]);
            get_sets(nums,i+1,ans);
            ans.remove(ans.size()-1);
        }
    }
}
