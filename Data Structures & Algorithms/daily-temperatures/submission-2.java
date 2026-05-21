class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int higherTemps = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i])  {
                    higherTemps = j - i;
                    break;
                }
            }
            res[i] = higherTemps;
        } 
        return res;
    }
}
