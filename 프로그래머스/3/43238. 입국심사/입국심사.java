import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        
    Arrays.sort(times);
    int cnt = times.length;
    long left = 1;
    long right = (long) n *  (long) times[cnt-1] + 1;
    long mid = (left + right) / 2;

    while (left <= right) {
      long person = 0;
      for (int i = 0; i < cnt; i++) {
        person += mid / times[i];
      }
      if (person < n) {
        left = mid + 1;
      } else if (person >= n) {
        right = mid - 1;
      }
      mid = (left + right) / 2;
    }
    return mid+1;
    }
}