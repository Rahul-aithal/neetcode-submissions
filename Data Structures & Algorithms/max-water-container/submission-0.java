class Solution {
    public int maxArea(int[] heights) {
        int maxv=0;
        int i=0,j=heights.length-1;
        while(i<j){
            int hi = heights[i];
            int hj = heights[j];
            int dist = (j - i) * min(heights[i], heights[j]);
            maxv  = max(dist,maxv);
            if(hi>hj){

            j--;
            }else if(hj>hi){
            i++;
            }
            else{
              j--;
            }
                 
        }
        return maxv;
    }
     public  int max(int a, int b){
        if(a>b) return a;
        else return b;

    }
         public  int min(int a, int b){
        if(a>b) return b;
        else return a;

    }
}
