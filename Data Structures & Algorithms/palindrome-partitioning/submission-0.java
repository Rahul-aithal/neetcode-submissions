class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> sub = new ArrayList<>();
        dfs(0,s,sub);
        return res;
    }

    public void dfs(int i,String s,List<String> ls){
        if(i>=s.length()){
            res.add(new ArrayList<>(ls));
            return;
        }

        for(int j=i;j<s.length();j++){
            if(isPali(s,i,j)){
                ls.add(s.substring(i,j+1));
                dfs(j+1,s,ls);
                ls.remove(ls.size()-1);
            }
        }
    }

    public boolean isPali(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
