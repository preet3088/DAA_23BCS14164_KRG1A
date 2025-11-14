import java.util.*;

class Solution {
    public int closestSubarraySum(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int prefix = 0, bestSum = 0, bestDiff = Integer.MAX_VALUE;
        for (int x : nums) {
            prefix += x;
            Integer floor = set.floor(prefix - k);
            Integer ceil = set.ceiling(prefix - k);
            if (floor != null) {
                int sum = prefix - floor;
                int diff = Math.abs(sum - k);
                if (diff < bestDiff) {
                    bestDiff = diff;
                    bestSum = sum;
                }
            }
            if (ceil != null) {
                int sum = prefix - ceil;
                int diff = Math.abs(sum - k);
                if (diff < bestDiff) {
                    bestDiff = diff;
                    bestSum = sum;
                }
            }
            set.add(prefix);
        }
        return bestSum;
    }
}
