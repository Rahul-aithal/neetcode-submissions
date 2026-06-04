class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = piles[0];
        for (int i = 1; i < piles.length; i++) {
            maxVal = Math.max(piles[i], maxVal);
        }
        if(piles.length==h) return maxVal;
        int minRate = 1;
        int low = 1, high = maxVal;
        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = sumOftime(piles, mid);
            System.out.println("mid: " + mid);
            System.out.println(sum);

            if (sum > h) {
                low = mid + 1;
            } else {
                high = mid - 1;
                minRate = mid;
            }
        }
        return minRate;
    }
    public static int sumOftime(int[] piles, int k) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            

                sum += Math.ceil((double) piles[i] / k);
        }
        return sum;
    }
}
