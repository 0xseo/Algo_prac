import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
    Queue<int[]> q = new LinkedList<>();
    int inf = 99999;
    int max = -inf;
    int[] costs = new int[n+1];
    List<Integer>[] canGo = new ArrayList[n+1];
    for (int i = 1; i <= n; i++) {
      costs[i] = inf;
      canGo[i] = new ArrayList<>();
    }
    costs[1] = 0;

    for (int i = 0; i < edge.length; i++) {
      int a = edge[i][0];
      int b = edge[i][1];
      canGo[a].add(b);
      canGo[b].add(a);
    }

    q.add(new int[] {1, 0});

    while (!q.isEmpty()) {
      int curNode = q.peek()[0];
      int cost = q.peek()[1];
      q.poll();

      max = Math.max(max, cost);

      for (int i = 0; i < canGo[curNode].size(); i++) {
        int nextNode = canGo[curNode].get(i);
        if (costs[nextNode] > cost + 1) {
          q.add(new int[] {nextNode, cost+1});
          costs[nextNode] = cost + 1;
        }
      }
    }

    for (int i = 2; i <= n; i++) {
      if (costs[i] == max) answer++;
    }
        return answer;
    }
}