class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int i=0,j=0;
        Set<Character> se = new HashSet<>();
        while(i<=j&&j<s.length()){
            if(se.add(s.charAt(j))){
                // System.out.println(se.size()+" "+s.charAt(j));
                maxLength = max(maxLength,j-i+1);
                j++;
            }else{
                i++;
                //  System.out.println(s.charAt(i)+" "+s.charAt(j));
                //  se.remove(s.charAt(j));
                se.clear();
                se.add(s.charAt(i));
                j=i+1;
            }
        }
        return maxLength;
    }
    static public int max(int a,int b){
        if(a<b) return b;
        else return a;
    }
}
