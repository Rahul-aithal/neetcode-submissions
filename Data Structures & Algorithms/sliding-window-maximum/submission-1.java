// import java.*
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> maxItems = new ArrayList<Integer>();

        for (int i = 0; i <= nums.length - k; i++) {
            int y = maxOfN(i, i + k-1, nums);
            maxItems.add(y);
        }
        return maxItems.stream().mapToInt(i->i).toArray();
    }
    public static int maxOfN(int i, int k, int[] nums) {

        if(i==k){
            return nums[i];
        }
        if (k - i == 1) {
            if (nums[i] < nums[k])
                return nums[k];
            else
                return nums[i];
        }
        // System.out.println("i: "+i+" k: "+k+" k-i= "+ (k-i));
        int mid = (i+k)/2;
        int x = maxOfN(i,mid,nums);
        // System.out.println("mid: "+mid);

        int y = maxOfN( mid+1, k, nums);
        // System.out.println("Y: "+y+" k/2: "+k/2);
        // int x =0;
        // int y=0;
        if (x > y)
            return x;
        else
            return y;
    }
}
