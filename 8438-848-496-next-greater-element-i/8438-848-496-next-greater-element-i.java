class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
              // Map to store the next greater element for each number in nums2
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        
        // Stack to keep track of elements for which we haven't found the next greater element yet
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 to calculate the next greater element for each number
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // For the remaining elements in the stack, there is no next greater element
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }

        // Prepare the result array for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}