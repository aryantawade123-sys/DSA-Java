class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : invocations) {
            graph.get(edge[0]).add(edge[1]);
        }
        boolean[] suspicious = new boolean[n];
        dfs(k, graph, suspicious);
        for (int[] edge : invocations) {
            int from = edge[0], to = edge[1];
            if (!suspicious[from] && suspicious[to]) {
                List<Integer> all = new ArrayList<>();
                for (int i = 0; i < n; i++) all.add(i);
                return all;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) result.add(i);
        }
        return result;
    }
    private void dfs(int node, List<List<Integer>> graph, boolean[] suspicious) {
        if (suspicious[node]) return;
        suspicious[node] = true;
        for (int nei : graph.get(node)) {
            dfs(nei, graph, suspicious);
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.remainingMethods(4, 1, new int[][]{{1,2},{0,1},{3,2}})); 
        System.out.println(sol.remainingMethods(5, 0, new int[][]{{1,2},{0,2},{0,1},{3,4}})); // [3,4]
        System.out.println(sol.remainingMethods(3, 2, new int[][]{{1,2},{0,1},{2,0}})); 
    }
}
