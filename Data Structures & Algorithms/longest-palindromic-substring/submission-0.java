class Solution {
    public String longestPalindrome(String s) {
        int st = 0, e = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = s.length(); i > j; i--) {
                // System.out.println(s.substring(j, i));
                if (isPalin(s.substring(j, i))) {
                    if (Math.abs(st - e) < Math.abs(i - j)) {
                        st = j;
                        e = i;
                    }
                }
            }
        }
        return s.substring(st, e);
    }
    public boolean isPalin(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
