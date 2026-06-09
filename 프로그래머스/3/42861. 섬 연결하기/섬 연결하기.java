import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);
    List<Integer>[] canGoFrom = new ArrayList[n];
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      visited[i] = false;
      canGoFrom[i] = new ArrayList<>();
    }

    for (int i = 0; i < costs.length; i++) {
      canGoFrom[costs[i][0]].add(i);
      canGoFrom[costs[i][1]].add(i);
    }


    visited[0] = true;
    for (int i = 0; i < canGoFrom[0].size(); i++) {
      int edgeIdx = canGoFrom[0].get(i);
      int toNode = Math.max(costs[edgeIdx][0], costs[edgeIdx][1]);
      pq.add(new int[] {costs[edgeIdx][2], toNode});
    }

    while (!pq.isEmpty()) {
      int cost = pq.peek()[0];
      int nextNode = pq.peek()[1];
      pq.poll();

      if (!visited[nextNode]) {
        visited[nextNode] = true;
        answer += cost;
        for (int i = 0; i < canGoFrom[nextNode].size(); i++) {
          int edgeIdx = canGoFrom[nextNode].get(i);
          int toNode = costs[edgeIdx][0] + costs[edgeIdx][1] - nextNode;
          pq.add(new int[] {costs[edgeIdx][2], toNode});
        }
      }
    }

    return answer;
    }
}