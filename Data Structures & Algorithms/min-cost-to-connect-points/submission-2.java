class Cord {
    int x, y;
    public Cord() {}
    public Cord(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int[] get() {
        return new int[] {x, y};
    }

    public void putX(int x) {
        this.x = x;
    }
    public void putY(int Y) {
        this.y = y;
    }
}

class Dist {
    double dist;
    Cord c1, c2;
    Dist() {}
    Dist(Cord c1, Cord c2) {
        this.dist = Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y);
        this.c1 = c1;
        this.c2 = c2;
    }

    public double getDist() {
        return dist;
    }
    public Cord getCord1() {
        return c1;
    }
    public Cord getCord2() {
        return c2;
    }

    public void setCord1(Cord c) {
        this.c1 = c1;
    }
    public void setCord2(Cord c) {
        this.c2 = c2;
    }
}
class Solution {
    HashMap<Cord, List<Dist>> map = new HashMap<>();
    public int minCostConnectPoints(int[][] points) {
        List<Cord> cords = new ArrayList<>();
        for (int[] point : points) {
            Cord c = new Cord(point[0], point[1]);
            cords.add(c);
        }

        for (Cord c1 : cords) {
            for (Cord c2 : cords) {
                if (c1 == c2) {
                    continue;
                }
                Dist d = new Dist(c1, c2);
                map.computeIfAbsent(c1, k -> new ArrayList<>()).add(d);
            }
        }

        Set<Cord> visited = new HashSet<Cord>();
        PriorityQueue<Dist> minHeap =
            new PriorityQueue<>(Comparator.comparingDouble(Dist::getDist));
        Dist init = new Dist(cords.get(0), cords.get(0));
        minHeap.offer(init);
        int cost = 0;
        while (!minHeap.isEmpty()) {
            Dist dist = minHeap.poll();

            if (visited.contains(dist.getCord2())) {
                continue;
            }
            cost += dist.getDist();
            visited.add(dist.getCord2());
            if (map.get(dist.getCord2()) == null)
                continue;
            for (Dist d : map.get(dist.getCord2())) {
                if (visited.contains(d.getCord2())) {
                    continue;
                }
                minHeap.offer(d);
            }
        }
        return cost;
    }
}
