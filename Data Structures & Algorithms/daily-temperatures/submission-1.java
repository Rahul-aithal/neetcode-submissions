class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack <Integer> stack = new Stack<>();
        int[] res =new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
            continue;
            }
            while(!stack.isEmpty()){
                int prevI = stack.peek();
                int diff = temperatures[prevI]-temperatures[i];
                System.out.println("prevI: "+prevI);                
                System.out.println("diff: "+diff);
                if(diff>=0){
              
                    break;
                } 
                
                res[prevI]=i-prevI;
                // System.out.println(res[prevI]);
               stack.pop(); 
            }
      stack.push(i);
        }
        return res;
    }
}
