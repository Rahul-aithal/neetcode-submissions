class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer>sm = new HashMap<Character,Integer>();
        HashMap<Character,Integer>tm = new HashMap<Character,Integer>();

        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            char sch = s.charAt(i);
            if(sm.get(sch)==null){
               sm.put(sch,1);
            }
            else{
                int scount = sm.get(sch);
                sm.put(sch,scount+1);
            }
            char  tch = t.charAt(i);
            if(tm.get(tch)==null){
                tm.put(tch,1);
            }
            else{
            int tcount = tm.get(tch);
                tm.put(tch,tcount+1);
            }
        }
         for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(tm.get(ch)==null){
                return false;
            }
            int scount = sm.get(ch);
            int tcount = tm.get(ch);
            if(scount!=tcount){
                return false;
            }
            
        }
                        return true;

    }
}
