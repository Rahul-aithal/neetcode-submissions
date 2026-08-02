class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder str = new StringBuilder();
        backtrack(n, 0, 0, str);
        return res;
    }
    void backtrack(int n, int open, int close, StringBuilder str) {
        if (open == n && close == n) {
            res.add(str.toString());
            return;
        }
        // if(open<close) return;
        // if(open>n)return;
        // if(open==n){
        //      str.append(')');
        //   backtrack(n,open,close+1,str);
        //   return;
        // }
        if (open > close) {
            str.append(')');
            backtrack(n, open, close + 1, str);
            str.deleteCharAt(str.length() - 1);
        }
        if (open < n) {
            str.append('(');
            backtrack(n, open + 1, close, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
