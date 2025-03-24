class StockSpanner {
  Stack<int[]> st;
    int ind;

    public StockSpanner() {
        st = new Stack<>();
        ind = -1;
    }
    
    public int next(int price) {
        ind++;

        // Pop elements from the stack while top price <= current price
        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }

        // Calculate the span based on the index difference
        int ans = ind - (st.isEmpty() ? -1 : st.peek()[1]);

        // Push the current price and index to the stack
        st.push(new int[]{price, ind});

        return ans;
    }
    
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */