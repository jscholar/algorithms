class CustomStack {
    int[] stack;
    int size;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        size = 0;
    }
    
    public void push(int x) {
        if (size < stack.length) {
            stack[size] = x;
            size++;
        }
    }
    
    public int pop() {
        if (size > 0) {
            size--;
            return stack[size];
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < k && i < size; i++) {
            stack[i] += val;
        }
    }
}