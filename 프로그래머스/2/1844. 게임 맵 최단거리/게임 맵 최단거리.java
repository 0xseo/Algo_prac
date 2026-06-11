import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
    int m = maps[0].length;
    int minCost = 10000;
    int[] dy = new int[] {1, -1, 0, 0};
    int[] dx = new int[] {0, 0, 1, -1};
    int[][] visitedCost = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        visitedCost[i][j] = minCost;
      }
    }
    visitedCost[0][0] = 0;

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {0, 0, 0});

    while (!q.isEmpty()) {
      int curY = q.peek()[0];
      int curX = q.peek()[1];
      int curCost = q.peek()[2];
      q.poll();

      if (curY == n-1 && curX == m-1) {
        minCost = Math.min(minCost, curCost);
        continue;
      }

      for (int i = 0; i < 4; i++) {
        int ny = curY + dy[i];
        int nx = curX + dx[i];
        if (0 <= ny && ny < n && 0 <= nx && nx < m) {
          if (maps[ny][nx] == 1 && visitedCost[ny][nx] > curCost + 1) {
            visitedCost[ny][nx] = curCost + 1;
            q.add(new int[] {ny, nx, curCost + 1});
          }
        }
      }
    }
    if (visitedCost[n-1][m-1] == 10000) return -1;
    return minCost+1;
    }
}