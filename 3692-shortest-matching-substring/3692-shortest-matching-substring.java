class Solution {
    public int shortestMatchingSubstring(String s, String p) {
        
    
if (p.startsWith("*") && p.endsWith("*") && s.contains(p.replace("*", ""))) return p.length()-2;
        if(s.contains(p.replace("*", ""))) return p.length() - 2;

        List<Pair<String, List<Integer>>> patIndices = new ArrayList<>();

        for(int i=0; i<p.length(); i++){
            StringBuilder sb = new StringBuilder();
            while(i < p.length() && p.charAt(i) != '*'){
                sb.append(p.charAt(i++));
            }
            if(sb.length() > 0){
                patIndices.add(new Pair(sb.toString(), kmp(sb.toString(), s)));
            }
        }

        if (patIndices.isEmpty()) return -1;
        // System.out.println(patIndices);
        int res = Integer.MAX_VALUE;
        for (int i : patIndices.get(0).getValue()) {
            int next = i + patIndices.get(0).getKey().length();
            int lastIdx = i;
            
            for (int j = 1; j < patIndices.size(); j++) {
                int bestIdx = bs(next, patIndices.get(j).getValue());
                if (bestIdx == Integer.MAX_VALUE) return res == Integer.MAX_VALUE ? -1 : res;
                next = bestIdx + patIndices.get(j).getKey().length();
                lastIdx = bestIdx;
            }

            res = Math.min(res, lastIdx - i + patIndices.get(patIndices.size() - 1).getKey().length());
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int bs(int target, List<Integer> l) {
        int lo = 0, hi = l.size() - 1, ans = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (l.get(mid) >= target) {
                ans = l.get(mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private List<Integer> kmp(String pat, String s) {
        int n = pat.length(), m = s.length();
        int[] lps = new int[n];
        int j = 0, i = 1;
        while (i < n) {
            if (pat.charAt(i) == pat.charAt(j)) {
                lps[i++] = ++j;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        // System.out.println(Arrays.toString(lps));
        List<Integer> patStart = new ArrayList<>();
        j = 0;
        i = 0;
        while (i < m) {
            if (s.charAt(i) == pat.charAt(j)) {
                j++;
                i++;
            }else{
                if(j > 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
            if(j == n){
                patStart.add(i - n);
                j = lps[j - 1];
            }
        }
        // System.out.println(patStart);
        return patStart;
    }
}
