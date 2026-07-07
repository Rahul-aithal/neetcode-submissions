class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length<1)return 0;
        if(stones.length==1) return stones[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(int stone:stones){
            maxHeap.offer(stone);
        }
      
        while(maxHeap.size()>1){
            int st1 = maxHeap.poll();
            int st2 = maxHeap.poll();
            if(st1==st2) continue;
            maxHeap.offer(Math.abs(st1-st2));
        }
          if(maxHeap.isEmpty()){
            return 0;
        }else
        return maxHeap.peek();
    }
}
