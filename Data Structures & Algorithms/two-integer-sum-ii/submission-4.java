class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while(j>i){
           int res = numbers[i]+numbers[j];
            if(res==target){
                return new int[]{i+1,j+1};
            }
              
            else if(res>target){
                j--;
            }
            else{
                i++;
            }
        }
        return null;
    }
}
