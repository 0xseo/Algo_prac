import java.util.*;
class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int inf = Integer.MAX_VALUE;
    int[][] map = new int[m][n];
    int[][] tempX = new int[m][n-w+1];
    int[][] tempY = new int[m-h+1][n-w+1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        map[i][j] = inf;
      }
    }

    for (int i = 0; i < drops.length; i++) {
      int y = drops[i][0];
      int x = drops[i][1];
      map[y][x] = i;
    }

    for (int y = 0; y < m; y++) {
      tempX[y] = getMin1D(map[y], w);
    }

    for (int x = 0; x < n-w+1; x++) {
      int[] colArr = new int[m];
      for (int y = 0; y < m; y++) {
        colArr[y] = tempX[y][x];
      }

      int[] minCol = getMin1D(colArr, h);
      for (int y = 0; y < minCol.length; y++) {
        tempY[y][x] = minCol[y];
      }
    }

    

    int maxV = -1;
    int maxY = -1;
    int maxX = -1;
    for (int y = 0; y < m - h + 1; y++) {
      for (int x = 0; x < n - w + 1; x++) {
        if (tempY[y][x] == inf) return new int[] {y, x};
        if (maxV < tempY[y][x]) {
          maxV = tempY[y][x];
          maxX = x;
          maxY = y;
        }
      }
    }


    int[] answer = {maxY, maxX};
    return answer;
  }

  int[] getMin1D(int[] arr, int K) {
    int[] temp = new int[arr.length - K + 1];
    Deque<Integer> deque = new ArrayDeque<>();
    int idx = 0;
    for (int i = 0; i < arr.length; i++) {
      if (!deque.isEmpty() && deque.peekFirst() < i - K + 1) {
        deque.pollFirst();
      }
      while (!deque.isEmpty() && arr[i] <= arr[deque.peekLast()]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      if (i >= K-1) temp[idx++] = arr[deque.peekFirst()];
    }
    return temp;
  }
}