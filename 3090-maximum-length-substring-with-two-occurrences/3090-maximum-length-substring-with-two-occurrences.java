class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int left = 0, maxLen = 0;

        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']++;

            // shrink window if any char count > 2
            while (freq[s.charAt(right) - 'a'] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
