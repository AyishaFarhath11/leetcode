class Solution {
    public int hIndex(int[] citations) {
         if(citations[citations.length-1]==0) return 0; // No paper has any citations.
    int s = 0, e = citations.length - 1;
    while(s <= e) {
        int m = s + (e - s) / 2;
        // Check if the number of papers with at least citations[m] equals citations[m]
        if(citations[m] == citations.length - m) {
            return citations[m];
        }
        // If there are more papers than citations[m], search to the right.
        if(citations[m] < citations.length - m) {
            s = m + 1;
        } else {
            // Otherwise, search to the left.
            e = m - 1;
        }
    }
    // The h-index is the number of papers with citations >= (citations.length - s)
    return citations.length - s;
    }
}