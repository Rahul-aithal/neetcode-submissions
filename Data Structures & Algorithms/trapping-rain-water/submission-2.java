class Solution {
    public int trap(int[] height) {
     int l=0,r=height.length-1;
     int vol = 0;
     int lmax =height[l], rmax =height[r];
    //  if()
while(l<r){
    if(lmax<=rmax){
        l++;
        lmax = max(lmax,height[l]);
        vol += lmax-height[l];
    }else{
        r--;
        rmax = max(rmax,height[r]);
        vol += rmax-height[r];
    }
    
}
     
     return vol;  
    }
     public int max(int a,int b){
        if(a<b){
            return b;
        }else return a;
    }
}
