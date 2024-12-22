class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String rule : allowed) {
            String base = rule.substring(0, 2); // First two characters
            char top = rule.charAt(2);          // Third character
            map.computeIfAbsent(base, k -> new ArrayList<>()).add(top);
        }

        // Step 2: Start recursive backtracking
        return canBuild(bottom, "", map, 0);
    }
    private static boolean canBuild(String currentRow, String nextRow, Map<String, List<Character>> map, int index) {
        // Base case: If we are at the top of the pyramid
        if (currentRow.length() == 1) {
            return true;
        }

        // If we have completed building the next row, recurse on it
        if (index == currentRow.length() - 1) {
            return canBuild(nextRow, "", map, 0);
        }

        // Get the base pair
        String base = currentRow.substring(index, index + 2);
        if (!map.containsKey(base)) {
            return false; // No valid top block for this base pair
        }

        // Try all possible top blocks for the current base pair
        for (char top : map.get(base)) {
            if (canBuild(currentRow, nextRow + top, map, index + 1)) {
                return true;
            }
        }

        // If no valid top block leads to a solution, return false
        return false;
    }

}