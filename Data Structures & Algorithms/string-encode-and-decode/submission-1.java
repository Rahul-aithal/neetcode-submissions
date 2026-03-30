class Solution {

    public String encode(List<String> strs) {
        StringBuilder finalString = new StringBuilder();
        for(String s:strs){
            StringBuilder str = new StringBuilder(s);
            // str.insert(0,str.substring(str.length()-3,str.length()-1));
            // str.delete(str.length()-3,str.length()-1);
            str.append('\n');
            finalString.append(str.toString());
        }
        return finalString.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<String>();
        StringBuilder index = new StringBuilder();
        for(char ch:str.toCharArray()){
            if(ch=='\n'){
                // index.insert(index.length()-3,index.substring(0,2));
                strs.add(index.toString());
                index.delete(0,index.length());
                continue;
            }
    index.append(ch);
        }
        return strs;
    }
}
