class Solution {
    public boolean hasDuplicate(int[] nums) {
HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            // System.out.println(i)
            int val = nums[i];
            if(m.get(val)==null){
                m.put(val,1);
            }
            else{
                return true;
            }
        }
                return false;

    }
}