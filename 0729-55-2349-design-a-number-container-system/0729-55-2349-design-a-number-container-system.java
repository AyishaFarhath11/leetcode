class NumberContainers {
 private Map<Integer, PriorityQueue<Integer>> res;
    private Map<Integer, Integer> index_val;
    public NumberContainers() {
         res = new HashMap<>();
        index_val = new HashMap<>();
    }
    
    public void change(int index, int number) {
         if (index_val.containsKey(index)) {
            int prevNum = index_val.get(index);
            if (prevNum == number) return;
            res.get(prevNum).remove(index);
         }
         res.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
        index_val.put(index, number);
    }
    
    public int find(int number) {
          PriorityQueue<Integer> pq = res.getOrDefault(number, new PriorityQueue<>());
        return pq.isEmpty() ? -1 : pq.peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */