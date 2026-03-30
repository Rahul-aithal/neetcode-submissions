class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        List<List<String>> strings =  new ArrayList<List<String>>();
        for(int i=0;i<strs.length;i++){
            if(m.get(i)!=null) continue;
            m.put(i,1);
            List<String> stri =new ArrayList<String>();
            
            stri.add(strs[i]);
            // System.out.println(strs[i]);
            for(int j=0;j<strs.length;j++){
            if(m.get(j)!=null) continue;
                    if(isAnagrams(strs[i],strs[j])==true){
                    stri.add(strs[j]);
                     m.put(j,1);
                    }
                
            }
            strings.add(stri);
        }
        return strings;
    }
    public static boolean isAnagrams(String a,String b){
        HashMap<Character,Integer> m = new HashMap<Character,Integer>();
        
        if(a.length()!=b.length()){
            return false;
        }
        for(int i = 0;i<a.length();i++){
            char c = a.charAt(i);
            if(m.get(c)==null){
                m.put(c,1);
            }else{
                m.put(c,m.get(c)+1);
            }
            char d = b.charAt(i);
            if(m.get(d)==null){
                m.put(d,-1);
            }else{
                m.put(d,m.get(d)-1);
            }
        }
        for(int i=0;i<a.length();i++){
            char c = a.charAt(i);
            if(m.get(c)==null||m.get(c)!=0){
                return false;
            }
        }
        return true;
    }
}
