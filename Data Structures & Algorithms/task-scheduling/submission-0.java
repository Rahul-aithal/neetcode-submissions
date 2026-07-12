class Solution {
    class Process {
        public char task;
        public int count;
        public int clock;
        Process(char task, int count, int clock) {
            this.task = task;
            this.count = count;
            this.clock = clock;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Process> maxHeap =
            new PriorityQueue<Process>((a, b) -> Integer.compare(b.count, a.count));
        Deque<Process> queue = new ArrayDeque<Process>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        map.forEach((key, value) -> {
            Process p = new Process(key, value, 0);
            maxHeap.offer(p);
        });

        int globalClock = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            Process p = maxHeap.poll();
            while (p != null && p.clock > globalClock && !maxHeap.isEmpty()) {
                queue.offer(p);
                p = maxHeap.poll();
            }
            if (p.clock <= globalClock) {
                p.clock += (n+1);
                p.count--;
            }
            if (p.count > 0) {
                queue.offer(p);
            }
            if (!queue.isEmpty()) {
                maxHeap.offer(queue.poll());
            }
            globalClock++;

            System.out.println("Global " + globalClock);
            System.out.println("Process: " + p.task + " " + p.count + " " + p.clock);
        }
        return globalClock;
    }
}
