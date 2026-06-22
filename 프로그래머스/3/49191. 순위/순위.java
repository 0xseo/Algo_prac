import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
    int inf = 99999;
    int[][] dist = new int[n+1][n+1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j<= n; j++) {
        dist[i][j] = inf;
        if (i == j) dist[i][j] = 0;
      }
    }

    for (int i = 0; i < results.length; i++) {
      int winner = results[i][0];
      int loser = results[i][1];
      dist[winner][loser] = 1;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        for (int k = 1; k <= n; k++) {
          dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
        }
      }
    }

    int[] inD = new int[n+1];
    int[] outD = new int[n+1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (dist[j][i] > 0 && dist[j][i] != inf) inD[i]++;
        if (dist[i][j] > 0 && dist[i][j] != inf) outD[i]++;
      }
    }

    for (int i = 1; i <= n; i++) {
      if (inD[i] + outD[i] == n-1) answer++;
    }
    
    
    return answer;
    }
}