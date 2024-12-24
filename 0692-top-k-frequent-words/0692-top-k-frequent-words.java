class Solution {
    public List<String> topKFrequent(String[] words, int k) {
          // Use a hashmap to store the frequency of each word
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Use a priority queue to sort words by frequency and lexicographical order
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int freqDiff = freqMap.get(a) - freqMap.get(b);
            if (freqDiff == 0) {
                return b.compareTo(a);
            }
            return freqDiff;
        });

        for (String word : freqMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result);
        return result;
    }
}