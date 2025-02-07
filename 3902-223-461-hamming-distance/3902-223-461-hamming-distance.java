class Solution {
    public int hammingDistance(int x, int y) {
        int bit = 0, count = 0;
        while (bit < 32) {
            if ((x >> bit & 1) != (y >> bit & 1))
                count++;
            bit++;
        }
        return count;
    }
}