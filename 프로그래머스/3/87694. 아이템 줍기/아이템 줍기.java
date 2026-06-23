import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};

    int[][] map = new int[101][101];
    boolean[][] visited = new boolean[101][101];
    for (int i = 1; i <= 100; i++) {
      for (int j = 1; j <= 100; j++) {
        map[i][j] = 0;
        visited[i][j] = false;
      }
    }

    for (int i = 0; i < rectangle.length; i++) {
      int x1 = rectangle[i][0]*2;
      int y1 = rectangle[i][1]*2;
      int x2 = rectangle[i][2]*2;
      int y2 = rectangle[i][3]*2;

      for (int x = x1; x <= x2; x++) {
        map[x][y1] = 1;
        map[x][y2] = 1;
      }
      for (int y = y1; y <= y2; y++) {
        map[x1][y] = 1;
        map[x2][y] = 1;
      }
    }

    for (int i = 0; i < rectangle.length; i++) {
      int x1 = rectangle[i][0]*2;
      int y1 = rectangle[i][1]*2;
      int x2 = rectangle[i][2]*2;
      int y2 = rectangle[i][3]*2;

      for (int x = x1+1; x < x2; x++) {
        for (int y = y1+1; y < y2; y++) {
          map[x][y] = 0;
        }
      }
    }
    

    Queue<int[]> q = new LinkedList<>();
    visited[characterX*2][characterY*2] = true;
    q.add(new int[] {characterX*2, characterY*2, 0});

    while (!q.isEmpty()) {
      int cx = q.peek()[0];
      int cy = q.peek()[1];
      int cost = q.peek()[2];

      q.poll();

      if (cx == itemX*2 && cy == itemY*2) {
        return cost/2;
      }

      for (int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];

        if (0 < nx && nx < 101 && 0 < ny && ny < 101) {
          if (map[nx][ny] == 0) continue;
          if (visited[nx][ny]) continue;
  
          visited[nx][ny] = true;
          q.add(new int[] {nx, ny, cost+1});
        }

      }
    }
    return 0;
    }
}