class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[n];
        int[] prefix = new int[n];
        int[] output = new int[n];
        for(int i=0; i< n;i++){
            if(i==0){
                prefix[i]=1;
                continue;
            }
            else{
             prefix[i]= prefix[i-1]*nums[i-1]; 
            }
        }
        for(int i=n-1; i>=0;i--){
            if(i==n-1){
                suffix[i]=1;
                continue;
            }
            else{
             suffix[i]= suffix[i+1]*nums[i+1]; 
            }
        }
        for(int i=0;i<n;i++){
            output[i] = prefix[i]*suffix[i];
        }
        return output;
    }
}  
