class Solution {
    public List<Integer> findDuplicates(int[] nums) {
         List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Calculate the index for the current number
            int index = Math.abs(nums[i]) - 1;

            // Check if the value at the index is already negative
            if (nums[index] < 0) {
                result.add(index + 1);
            } else {
                // Mark the number as seen by negating it
                nums[index] = -nums[index];
            }
        }

        // Restore the array to its original state if needed
       

        return result;
    }
}