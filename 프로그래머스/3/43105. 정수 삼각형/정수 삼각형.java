import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
    int[][] dp = new int[2][size+1];
    dp[0][1] = triangle[0][0];

    for (int turn = 0; turn < size - 1; turn++) {
      for (int x = 1; x <= triangle[turn+1].length; x++) {
        dp[1][x] = Math.max(dp[0][x-1], dp[0][x]) + triangle[turn+1][x-1];
      }
      for (int x = 1; x <= size; x++) {
        dp[0][x] = dp[1][x];
      }
    }
    int max = dp[1][1];
    for (int i = 1; i <= size; i++) {
      if (max < dp[1][i]) max = dp[1][i];
    }
    return max;
    }
}