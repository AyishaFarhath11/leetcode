class Solution {
    public String removeDuplicateLetters(String s) {
         int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Array to keep track of whether a character is in the result
        boolean[] inResult = new boolean[26];

        // Stack to build the result string
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Skip if the character is already in the result
            if (inResult[c - 'a']) {
                continue;
            }

            // Remove characters from the stack if they are lexicographically greater than the current character
            // and if they appear later in the string
            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                inResult[stack.pop() - 'a'] = false;
            }

            // Add the current character to the stack and mark it as included
            stack.push(c);
            inResult[c - 'a'] = true;
        }

        // Build the result string from the stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}