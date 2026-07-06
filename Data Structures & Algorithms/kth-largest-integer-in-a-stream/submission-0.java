class KthLargest {
    int k;
    PriorityQueue<Integer> heap ;
    public KthLargest(int k, int[] nums) {
        this.k = k;
       this.heap = new PriorityQueue<>();
    for(int num:nums){
        this.heap.offer(num);
        if(heap.size()>k){
            heap.poll();
        }
    }
    //   return heap.peek();
    }
    
    public int add(int val) {
         this.heap.offer(val);
        if(heap.size()>k){
            heap.poll();
        }
              return heap.peek();

    }
}
