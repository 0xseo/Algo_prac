import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
    for (int i = 0; i < citations.length; i++) {
      if (citations[citations.length - i - 1] == i+1) {
        return i+1;
      } else if (citations[citations.length - i - 1] < i+1) {
        return i;
      }
    }
    return citations.length;
    }
}