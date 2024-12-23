class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> tFreqMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreqMap.put(c, tFreqMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowFreqMap = new HashMap<>();
        int required = tFreqMap.size();
        int formed = 0;
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreqMap.put(c, windowFreqMap.getOrDefault(c, 0) + 1);

            if (tFreqMap.containsKey(c) && windowFreqMap.get(c).intValue() == tFreqMap.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);
                int windowLength = right - left + 1;
                if (windowLength < minLength) {
                    minLength = windowLength;
                    minLeft = left;
                }

                windowFreqMap.put(leftChar, windowFreqMap.get(leftChar) - 1);
                if (tFreqMap.containsKey(leftChar) && windowFreqMap.get(leftChar).intValue() < tFreqMap.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}