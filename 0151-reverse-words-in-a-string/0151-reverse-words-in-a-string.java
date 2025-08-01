class Solution {
    public String reverseWords(String s) {
            // Trim the string and split by spaces
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        // Append in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }

        return sb.toString(); 
    }
}