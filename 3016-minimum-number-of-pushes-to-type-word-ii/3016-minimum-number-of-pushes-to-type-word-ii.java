class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int total = 0;
        int index = 0;

        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;
            int cost = (index / 8) + 1; 
            total += freq[i] * cost;
            index++;
        }
        return total;
    }
}
