class ProductOfNumbers {

    private Stack<Integer> stack;
    
    public ProductOfNumbers() {
        stack = new Stack<>();
    }
    
    public void add(int num) {
        // if(stack.empty()) {
            stack.push(num);
        // } else {
            // int previous = stack.peek();
            // stack.push(previous * num);
        // }
    }
    
    public int getProduct(int k) {
        
        Stack<Integer> tempStack = new Stack<>();
        int result = 1;
        
        while(k > 0) {
            int number = stack.pop(); 
            result *= number;
            tempStack.push(number);
            k--;
        }
        
        while(!tempStack.empty()) {
            stack.push(tempStack.pop());
        }
        
        return result;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */