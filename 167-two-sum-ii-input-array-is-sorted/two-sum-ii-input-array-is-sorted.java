class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement) + 1, i + 1}; // 1-based index
            }
            
            map.put(numbers[i], i); // store current number with index
        }
        
        return new int[] {-1, -1}; // no solution
    }
}
