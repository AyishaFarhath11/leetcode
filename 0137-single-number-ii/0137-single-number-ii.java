class Solution {
    public int singleNumber(int[] nums) {
         int ones = 0, twos = 0;

        for (int num : nums) {
            // Update `ones` to include current `num`, excluding numbers already in `twos`
            ones = (ones ^ num) & ~twos;

            // Update `twos` to include current `num`, excluding numbers already in `ones`
            twos = (twos ^ num) & ~ones;
        }

        return ones; // The single number remains in `ones`
    }
}