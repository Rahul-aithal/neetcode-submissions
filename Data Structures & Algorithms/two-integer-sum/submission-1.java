class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        int a=0;
        int b=1;
        for(int i=0;i<nums.length;i++){
            m.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(m.get(target-nums[i])!=null){
                int j = m.get(target-nums[i]);
                a=i;
                b=j;
                if(i!=j){
                    break;
                }
                continue;
            }
        }
        int[] arr = {a,b};
        return arr;
    }
}
