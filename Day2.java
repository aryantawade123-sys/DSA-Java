import java.util.*;

class Solution {
  public int[] twoSum(int[] a, int t) {
    Map<Integer,Integer> m = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      int n = t - a[i];
      if (m.containsKey(n)) return new int[]{m.get(n), i};
      m.put(a[i], i);
    }
    return new int[]{-1, -1}; // safety
  }
}
