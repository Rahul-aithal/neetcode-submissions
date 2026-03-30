class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";
        HashMap<Character,Integer>window = new HashMap<>();
        HashMap<Character,Integer> countT= new HashMap<>();
        for(char c:t.toCharArray()){
            countT.put(c,countT.getOrDefault(c,0)+1);
        }


        int[] res = new int[]{-1,-1};
        int resLen = Integer.MAX_VALUE;
        int l=0;
        int need = countT.size();
        int have = 0;

        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);

            window.put(c,window.getOrDefault(c,0)+1);

            if(countT.containsKey(c)&&window.get(c).equals(countT.get(c))){
                have++;
            }

            while (have==need) {
                if(( r - l + 1 ) < resLen){
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftCh = s.charAt(l);
window.put(leftCh, window.get(leftCh) - 1);
                if(countT.containsKey(leftCh)&&window.get(leftCh)<countT.get(leftCh)){
                    have--;
                }
                l++;
            }


        }

        if(resLen==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(res[0],res[1]+1);
    }
}
