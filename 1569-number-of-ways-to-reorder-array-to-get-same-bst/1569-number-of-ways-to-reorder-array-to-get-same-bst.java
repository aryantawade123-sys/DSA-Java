class Solution {
    static final int MOD = 1_000_000_007;
    long[] fact, invFact;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        fact = new long[n+1];
        invFact = new long[n+1];
        precompute(n);
        return (int)((dfs(toList(nums)) - 1 + MOD) % MOD);
    }
    private long dfs(List<Integer> arr) {
        if (arr.size() <= 2) return 1;
        int root = arr.get(0);
        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        for (int i = 1; i < arr.size(); i++)
            if (arr.get(i) < root) left.add(arr.get(i)); else right.add(arr.get(i));
        long l = dfs(left), r = dfs(right);
        return (((nCr(arr.size()-1, left.size()) * l) % MOD) * r) % MOD;
    }
    private void precompute(int n) {
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = fact[i-1] * i % MOD;
        invFact[n] = pow(fact[n], MOD-2);
        for (int i = n-1; i >= 0; i--) invFact[i] = invFact[i+1] * (i+1) % MOD;
    }
    private long nCr(int n, int r) {
        return fact[n] * invFact[r] % MOD * invFact[n-r] % MOD;
    }
    private long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD; b >>= 1;
        }
        return res;
    }
    private List<Integer> toList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);
        return list;
    }
}
