class Solution {
    public int minMoves2(int[] nums) {
         Arrays.sort(nums);

        // Find the median
        int median = nums[nums.length / 2];

        // Calculate the total moves to make all elements equal to the median
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        return moves;
    }
}