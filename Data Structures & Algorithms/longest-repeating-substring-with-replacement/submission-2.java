class Solution {
    public int characterReplacement(String s, int k) {
        // int repeatedCharCount = 0;
        int maxFreq=0,maxSub=0;
        int[] m = new int[26];
        int r=0,l=0;
        while(r<s.length()){
            m[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq,m[s.charAt(r)-'A']);
                
             
            while((r-l+1)-maxFreq>k){
                m[s.charAt(l)-'A']--;
                // maxFreq = max(m);
                System.out.println(maxFreq);
                l++;
            }
            if((r-l+1)-maxFreq<=k) {
                maxSub = Math.max(maxSub,(r-l+1));
                
                }
            r++;
        }
return maxSub;

        

    }
    static public int max(int[] a){
        int maxVal=Integer.MIN_VALUE ;
        for(int i=0;i<a.length;i++){
            if (maxVal<a[i]) maxVal=a[i];
        }
        return maxVal;

    }
}
