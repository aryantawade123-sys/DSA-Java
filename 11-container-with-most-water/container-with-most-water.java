class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1; // 1. Start at extreme boundaries
        int maxWater = 0;                        // 2. Track global max area
        
        while (left < right) {
            // 3. Area = Width (right - left) * Shortest Wall
            int currentWater = (right - left) * Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, currentWater); // 4. Update max
            
            // 5. Shift pointer with the smaller wall
            if (height[left] < height[right]) left++;
            else right--;
        }
        
        return maxWater;
    }
}