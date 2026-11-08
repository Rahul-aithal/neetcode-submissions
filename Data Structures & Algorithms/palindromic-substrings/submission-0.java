class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        boolean odd = s.length() % 2 != 0;
        for (int i = 0; i < s.length(); i++) {
            count = expand(i, i, s, count);

            count = expand(i, i + 1, s, count);
        }
        return count;
    }
    int expand(int l, int r, String s, int count) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            // System.out.println(s.substring(l, r + 1));

            l--;
            r++;
        }

        return count;
    }
}
