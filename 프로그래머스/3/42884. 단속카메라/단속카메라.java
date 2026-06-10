import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
    for (int i = 0; i < routes.length; i++) {
      pq.add(new int[] {Math.min(routes[i][0], routes[i][1]), Math.max(routes[i][0], routes[i][1])});
    }
    int lastCamera = 30001;
    int answer = 0;

    while (!pq.isEmpty()) {
      int inTime = pq.peek()[0];
      int outTime = pq.peek()[1];
      pq.poll();

      if (inTime <= lastCamera && lastCamera <= outTime) continue;
      else {
        answer++;
        lastCamera = outTime;
      }
    }
    return answer;
    }
}