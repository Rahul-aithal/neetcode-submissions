class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
     int m = matrix.length;
     int n = matrix[0].length;
     for(int i = 0; i<m;i++){
        if(matrix[i][0]>target) return false;
        if(matrix[i][n-1]<target) continue;
        else{
            // System.out.println(i);

            int l = 0;
            int r =n-1;
            while(l<r){
                int mid = ((l+r)/2);
                int value = matrix[i][mid];
                
                
                if(value==target) return true;
                else if(value>target) r = mid-1;
                else if(value<target) l = mid+1;
                else return false;
            }
            if(l==r){
                 if( matrix[i][l]==target) return true;
              
                else return false;
            }
        } 
     }   

        return false;
    }
}
