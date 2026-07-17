class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        minHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(a, b));
    }

    public void addNum(int num) {
        minHeap.offer(num);
        if ( !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
            maxHeap.offer(minHeap.poll());
        }
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size() ) {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }
        if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        }
        return (double) minHeap.peek();
    }
}
