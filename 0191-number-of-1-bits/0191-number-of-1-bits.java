class Solution {
    public int hammingWeight(int n) {
         int count = 0;

        while (n != 0) {
            // Increment count for each set bit
            count += n & 1;

            // Right shift `n` to check the next bit
            n >>>= 1; // Use unsigned right shift
        }

        return count;
    }
}