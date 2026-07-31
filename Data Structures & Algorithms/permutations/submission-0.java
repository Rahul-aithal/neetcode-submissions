class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new LinkedHashSet<>();

            compute(i, nums, set);
            // System.out.println("Worked on idx " + i + " value: " + nums[i]);
        }
        return res;
    }
    public void compute(int curr, int[] nums, Set<Integer> set) {
        if (curr >= nums.length)
            return;
        // System.out.println("Adding on curr " + curr + " value: " + nums[curr]);
            // System.out.println("Set is in begin "+ set);

        if (set.contains(nums[curr])) {
            // System.out.println("This was already done");
            return;
        }
        set.add(nums[curr]);
        // System.out.println("Added: "+ set);
        if (set.size() == nums.length) {
            // System.out.println("New one added");
            System.out.println(set);

            res.add(new ArrayList());
            res.get(res.size()-1).addAll(set);
            set.remove(nums[curr]);

            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == curr) {
                continue;
            } else
                compute(i, nums, set);
            // System.out.println("With parent curr " + curr + " value: " + nums[curr]);
            // System.out.println("Worked on i " + i + " value: " + nums[i]);
            // System.out.println("Set is "+ set);
        }
        set.remove(nums[curr]);
    }
}
