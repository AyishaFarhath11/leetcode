class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
     private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // Add to the result if the current sequence has at least 2 elements
        if (current.size() >= 2) {
            result.add(new ArrayList<>(current));
        }

        // Use a set to avoid duplicates in the same recursive depth
        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates or invalid sequences
            if (used.contains(nums[i]) || (!current.isEmpty() && nums[i] < current.get(current.size() - 1))) {
                continue;
            }

            // Mark this element as used and add it to the current sequence
            used.add(nums[i]);
            current.add(nums[i]);

            // Recurse to the next element
            backtrack(nums, i + 1, current, result);

            // Backtrack by removing the last added element
            current.remove(current.size() - 1);
        }
    }

}