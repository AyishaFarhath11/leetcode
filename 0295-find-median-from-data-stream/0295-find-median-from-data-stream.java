class MedianFinder {
     private PriorityQueue<Integer> small; // Max-Heap for the smaller half of the numbers
    private PriorityQueue<Integer> large; // Min-Heap for the larger half of the numbers
    private boolean even;
    public MedianFinder() {
           small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        even = true;


    }
    
    public void addNum(int num) {
        if (even) {
        large.offer(num);
        small.offer(large.poll());
    } else {
        small.offer(num);
        large.offer(small.poll());
    }
    even = !even;
    }
    
    public double findMedian() {
         if (even)
        return (small.peek() + large.peek()) / 2.0;
    else
        return small.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */