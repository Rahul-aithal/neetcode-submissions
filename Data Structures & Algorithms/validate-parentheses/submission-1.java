class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
    Character pp;
        for (Character ch : s.toCharArray()) {
            switch (ch) {
                case '[':
                    stack.push(ch);
                    break;
                case ']':
                    if (stack.isEmpty()) return false;
                   pp  = stack.pop();
                    if (pp != '[')
                        return false;
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                if (stack.isEmpty()) return false;
                     pp = stack.pop();
                    if (pp != '(')
                        return false;
                    break;
                case '{':
                    stack.push(ch);
                    break;
                case '}':
                if (stack.isEmpty()) return false;
                     pp = stack.pop();
                    if (pp != '{')
                        return false;
                    break;
                default:
                    return false;
                    
            }
        }

        return stack.isEmpty();
    }
}
