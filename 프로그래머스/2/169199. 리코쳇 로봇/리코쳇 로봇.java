import java.util.*;
import java.io.*;
class Solution {
    public int solution(String[] board) {
        int inf = Integer.MAX_VALUE;
        int n = board.length; int m = board[0].length();
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        int[][] dist = new int[n][m];
        int[] firstPos = {0, 0};
        int[] endPos = {0, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = inf;
                if (board[i].charAt(j) == 'R') {
                    firstPos[0] = i; firstPos[1] = j;
                } else if (board[i].charAt(j) == 'G') {
                    endPos[0] = i; endPos[1] = j;
                }
            }
        }
        dist[firstPos[0]][firstPos[1]] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {firstPos[0], firstPos[1], 0});
        
        while (!q.isEmpty()) {
            int y = q.peek()[0]; int x = q.peek()[1]; int cost = q.peek()[2];
            q.poll();
            if (y == endPos[0] && x == endPos[1]) return cost;
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i]; int nx = x + dx[i];
                if (0 <= ny && ny < n && 0 <= nx && nx < m) {
                    if ((board[ny].charAt(nx) == 'D')) continue;
                    int[] nextPos = findDest(new int[] {y, x}, i, board);
                    
                    if (dist[nextPos[0]][nextPos[1]] > cost+1) {
                        dist[nextPos[0]][nextPos[1]] = cost+1;
                        q.add(new int[] {nextPos[0], nextPos[1], cost+1});
                    }
                }
            }
        }
        
        return -1;
    }
    int[] findDest(int[] curPos, int direction, String[] board) {
        int n = board.length; int m = board[0].length();
        int y = curPos[0]; int x = curPos[1];
        while (0 <= y && y < n && 0 <= x && x < m && !(board[y].charAt(x) == 'D')) {
            if (direction == 0) y++;
            else if (direction == 1) y--;
            else if (direction == 2) x++;
            else x--;
        }
        
        if (direction == 0) return new int[] {y-1, x};
        else if (direction == 1) return new int[] {y+1, x};
        else if (direction == 2) return new int[] {y, x-1};
        else return new int[] {y, x+1};
    }
}
