class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
     int m = matrix.length;
     int n = matrix[0].length;
            
            // System.out.println(i);

            int l = 0;
            int r = matrix[0].length *m-1;;
            while(l<=r){
                int mid = ((l+r)/2);
                int row = mid/n;
                int col = mid%n;
                int value = matrix[row][col];
                
                
                if(value==target) return true;
                else if(value>target) r = mid-1;
                else if(value<target) l = mid+1;
                else return false;
            }
           
         
    

        return false;
    }
}
