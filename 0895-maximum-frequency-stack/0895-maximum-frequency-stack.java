class FreqStack {
     private Map<Integer, Integer> freqMap;  // Maps element to its frequency
    private Map<Integer, Stack<Integer>> freqStackMap;  // Maps frequency to elements with that frequency
    private int maxFreq;
    public FreqStack() {
         freqMap = new HashMap<>();
        freqStackMap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
          int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);

        if (freq > maxFreq) {
            maxFreq = freq;
        }

        freqStackMap.putIfAbsent(freq, new Stack<>());
        freqStackMap.get(freq).push(val);
    }
    
    public int pop() {
         Stack<Integer> stack = freqStackMap.get(maxFreq);
        int val = stack.pop();
        
        if (stack.isEmpty()) {
            maxFreq--;
        }

        freqMap.put(val, freqMap.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */