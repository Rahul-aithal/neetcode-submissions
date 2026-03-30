class Solution {
    public int longestConsecutive(int[] nums) {
        int max_len =0;
        int count=0;
Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
if(nums.length==0){return 0;}
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                continue;
            }
            else if(nums[i+1]-nums[i]==1){
                count++;
            }
            else{
                max_len = max(max_len,count);
                count=0;
            }
            // System.out.println(max_len+" "+count+" "+nums[i]+" "+nums[i+1]);
        }
        return max(max_len,count)+1;
    }
    static int max(int a,int b){
        if(a>b){
            return a;
        }else{
            return b;
        }
    }
}
