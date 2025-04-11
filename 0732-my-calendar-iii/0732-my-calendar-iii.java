class MyCalendarThree {
private TreeMap<Integer, Integer> lines;
    public MyCalendarThree() {
        lines = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
         lines.put(startTime, lines.getOrDefault(startTime, 0) + 1);
        // the event ends here -> decrease by 1
        // p.s. sometimes you may see `lines[end + 1]--;`. e.g. 2406. Divide Intervals Into Minimum Number of Groups
        //      you may search `leetcode-the-hard-way` on Discussion to see my solution explanation on that problem
        //      this is because the interval is inclusive, i.e [start, end] 
        //      however, the interval in this problem is [start, end), so we don't need to add 1 here.
        lines.put(endTime, lines.getOrDefault(endTime, 0) - 1);
        int mx = 0, cnt = 0;
        for (int x : lines.values()) {
            // here we calculate the prefix sum
            cnt += x;
            // and record the maximum overlapping intervals
            mx = Math.max(mx, cnt);
        }
        return mx;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */