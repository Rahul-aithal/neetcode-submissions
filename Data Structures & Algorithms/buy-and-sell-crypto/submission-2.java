class Solution {
    public int maxProfit(int[] prices) {
        int l=0,r=l+1;
        int maxProfit = 0;
        while(l<=r&&r<prices.length){
            int profit = prices[r]-prices[l];
                            System.out.println(profit);

            if(profit<0){
                l++;
                                System.out.println(l);

                // r=prices.length-1;
            }
            else{
                maxProfit=max(maxProfit,profit);
                r++;
                System.out.println(r);
            }
        }
        return maxProfit;
    }
    static public int max(int a,int b){
        if(a<b) return b;
        else return a;
    }
}
