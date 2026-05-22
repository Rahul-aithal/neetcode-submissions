class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        for (int i =0;i<heights.length;i++){
            int start=i;
            while(stack.size()>0&&stack.peek()[1]>=heights[i]){
                int[] top =  stack.pop();
                int area = (i-top[0])*top[1];
                maxArea = Math.max(area,maxArea);
                start = top[0]; 
            }
            int[] value = new int[2];
            value[0] = start;
            value[1]= heights[i];
            stack.push(value);
        }

        while(!stack.isEmpty()){
           int[] top =  stack.pop();
                int area = (heights.length-top[0])*top[1];
                maxArea = Math.max(area,maxArea);
                  
        }
        return maxArea;
    }
}
