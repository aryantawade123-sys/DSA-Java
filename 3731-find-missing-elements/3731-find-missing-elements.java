class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for (int x : nums) {
            mn = Math.min(mn, x);
            mx = Math.max(mx, x);
            set.add(x);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = mn + 1; i < mx; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findMissingElements(new int[]{1,4,2,5})); // [3]
        System.out.println(sol.findMissingElements(new int[]{7,8,6,9})); // []
        System.out.println(sol.findMissingElements(new int[]{5,1}));     // [2,3,4]
    }
}
