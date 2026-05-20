class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        HashMap<Character, Integer> freqS1 = new HashMap<>();
        boolean size = false;
        for (char c : s1.toCharArray()) {
            freqS1.put(c, freqS1.getOrDefault(c, 0) + 1);
            // resetValue.put(c,resetValue.getOrDefault(c,0)+1);
        }

        int r = 0, l = 0;
        HashMap<Character, Integer> currentWindow = new HashMap<>();
        int k = s1.length();
        System.out.println(k);
        while (r < s2.length()) {
            int count = 0;
            System.out.println("r: " + r);
            currentWindow.put(s2.charAt(r), currentWindow.getOrDefault(s2.charAt(r), 0) + 1);

            // if(s2.length()-r < s1.length()) return false;

            if ((r - l + 1) > k) {
                System.out.println("l: " + l);
                Character c = s2.charAt(l);
                currentWindow.put(c, currentWindow.getOrDefault(c, 0) - 1);
                l++;
            }
            if ((r - l + 1) == k) {
                for (char c : s1.toCharArray()) {
                    System.out.println(c + ": " + currentWindow.get(c));
                    if (currentWindow.get(c) != freqS1.get(c))
                        break;
                    else
                        count++;
                }
            }
            // System.out.println(count);
            if (count == s1.length()) {
                return true;
            }
            // l=r-(s1.length()-1);
            // l++;
            r++;
        }

        return false;
    }
}
