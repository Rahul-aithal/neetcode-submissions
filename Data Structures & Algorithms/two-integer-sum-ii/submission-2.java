class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while(j>i){
           int res = numbers[i]+numbers[j];
            if(res==target){
                return new int[]{i+1,j+1};
            }
            // while(numbers[j]>target&&j>i){
            //     System.out.println(j);
            //     j--;
            // }
           
             if(res>target){
                j--;
            }
            else{
                i++;
            }
        }
        return new int[]{0,0};
    }
}
