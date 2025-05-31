class ExamRoom {
 TreeSet<Integer> seats;
    int n;
    public ExamRoom(int n) {
        this.seats = new TreeSet<>();
        this.n = n;
    }
    
    public int seat() {
        if(seats.size() == 0){
            seats.add(0);
            return 0;
        }
        
        int seatToSit = 0;
        int maxDist = seats.first();
        int prev = Integer.MIN_VALUE;
        for(int curr : seats){
            if(prev != Integer.MIN_VALUE){
                int newElementDist = (curr - prev) / 2;
                if(newElementDist > maxDist){
                    maxDist = newElementDist;
                    int newSeat = prev + newElementDist;
                    seatToSit = newSeat;
                }
            }
            prev = curr;
        }
        if(n-1-seats.last() > maxDist){
            seatToSit = n-1;
        }
        seats.add(seatToSit);
        return seatToSit;
    }
    
    public void leave(int p) {
        seats.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */