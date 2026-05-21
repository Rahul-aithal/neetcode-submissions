class MinStack {
    int top;
    int min;
    // boolean isEmpty;
    ArrayList<Integer> stack;
    ArrayList<Integer> minarray;

    public MinStack() {
        top = -1;
        min = -1;
        stack = new ArrayList<>();
        minarray = new ArrayList<>();
        return;
    }

    public void push(int val) {
        stack.add(val);
        if (min == -1 || val <= minarray.get(min)) {
            minarray.add(val);
            min++;
        }
        top++;
        System.out.println("Push top:" + top);
        return;
    }

    public void pop() {
        // if(isEmpty) return;
        int value = stack.get(top);
        stack.remove(top);
        top--;
        // if (top==-1) isEmpty=true;

        if (min != -1 && minarray.get(min) == value) {
            minarray.remove(min);
            min--;
        }
        System.out.println("Pop top:" + top);
    }

    public int top() {
        if (top == -1)
            return -1;
        System.out.println("Current top:" + top);

        return stack.get(top);
    }

    public int getMin() {
        if (min == -1)
            return -1;
        System.out.println("getMin:" + minarray.get(min));
        return minarray.get(min);
    }
}
