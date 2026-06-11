class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
        int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
        int n = nums1.length + nums2.length;
        int left = (n + 1) / 2;
        int right = n - left;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int l = 0, r = n1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int mid2 = left - (mid );
            if (mid < n1) {
                r1 = nums1[mid];
            } else {
                r1 = Integer.MAX_VALUE;
            }
            if (mid>0) {
                l1 = nums1[mid-1];
            } else {
                l1 = Integer.MIN_VALUE;
            }
            if (mid2>0) {
                l2 = nums2[mid2-1];
            } else {
                l2 = Integer.MIN_VALUE;
            }
            if (mid2< n2) {
             
                r2 = nums2[mid2];
            } else {
               r2 = Integer.MAX_VALUE;
            }
            
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 0) {
                double lmax =(double) Math.max(l1, l2);

                    double rmin = (double)Math.min(r1, r2);

                    return (double) (lmax + rmin) / 2;
                } else {
                    return (double)Math.max(l1, l2);
                }
            }
            if (l2 > r1) {
                l = mid + 1;
            }
            if (l1 > r2) {
                r = mid - 1;
            }
        }
        return 0.0;
    }
}
