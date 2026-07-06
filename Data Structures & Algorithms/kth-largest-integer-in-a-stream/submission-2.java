class KthLargest {
    int k;
    PriorityQueue<Integer> heap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
        //   return heap.peek();
    }

    public int add(int val) {
        this.heap.offer(val);
        while (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
