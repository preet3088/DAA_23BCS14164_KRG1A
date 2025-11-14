import java.util.*;

class Solution {
    public int minPlatforms(int[] arr, int[] dep) {
        if (arr == null || dep == null || arr.length == 0) return 0;
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0, plat = 0, result = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                plat++; i++;
                if (plat > result) result = plat;
            } else {
                plat--; j++;
            }
        }
        return result;
    }
}
