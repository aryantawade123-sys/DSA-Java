class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '1' ? 1 : 0);
        }

        String ans = "";
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int ones = prefix[j + 1] - prefix[i];
                if (ones == k) {
                    int len = j - i + 1;
                    String candidate = s.substring(i, j + 1);
                    if (len < minLen || (len == minLen && candidate.compareTo(ans) < 0)) {
                        minLen = len;
                        ans = candidate;
                    }
                }
            }
        }
        return ans;
    }
}
