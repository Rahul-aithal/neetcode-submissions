class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < tokens.length; i++) {
            try {
                int operend = Integer.parseInt(tokens[i]);
                stack.push(operend);
            } catch (NumberFormatException nfe) {
                int op2 = stack.pop();
                // stack.pop();
                int op1 = stack.pop();
                // stack.pop();
                int res = eval(op1,tokens[i],op2);
                stack.push(res);
            }
        }
        return stack.peek();
    }
    public static int eval(int op1,String oper,int op2){
        switch(oper){
            case "+":
             return op1+op2;
            case "-":
             return op1-op2;
            case "*":
             return op1*op2;             
            case "/":
             return op1/op2;
             default:
             return 0;
        }
    } 
}
