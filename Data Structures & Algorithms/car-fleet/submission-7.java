class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        Stack<Double> stack = new Stack<Double>();

        for (int r = position.length - 1; r >= 0; r--) {
            // System.out.println(stack);

                double recent = 0;
                int last_p = position[r];
                int last_s = map.get(last_p);
                recent =(double) (target - last_p) / last_s;
                stack.push(recent);
           
            if (stack.size() >= 2)  {
                double top = stack.pop();
                double bottom = stack.peek();
                if (bottom < top) {
                    stack.push(top);
                }
            }
        }

        return stack.size();
    }
}
