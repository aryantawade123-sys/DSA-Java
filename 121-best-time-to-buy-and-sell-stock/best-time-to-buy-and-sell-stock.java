
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price); // Sasta stock update karein
            maxProfit = Math.max(maxProfit, price - minPrice); // Best profit update karein
        }
        return maxProfit;
    }
}
