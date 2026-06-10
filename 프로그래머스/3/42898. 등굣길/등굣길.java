import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int divBy = 1000000007;

        int[][] dp = new int[n+1][m+1];
    dp[1][1] = 1;
    for (int p = 0; p < puddles.length; p++) {
      dp[puddles[p][1]][puddles[p][0]] = -1;
    }
    for (int y = 1; y <= n; y++) {
      for (int x = 1; x <= m; x++) {
        if (dp[y][x] != -1) {
          if (dp[y][x-1] != -1) dp[y][x] += Math.floorMod(dp[y][x-1], divBy);
          if (dp[y-1][x] != -1) dp[y][x] += Math.floorMod(dp[y-1][x], divBy);
        dp[y][x] = Math.floorMod(dp[y][x], divBy);
        }
      }
    }

    return dp[n][m];
    }
}