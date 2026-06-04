import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int s : scoville) {
      pq.add(s);
    }
    int time = 0;
    while (true) {
      if (pq.isEmpty()) return -1;
      if (pq.peek() >= K) return time;
      if (pq.size() == 1 && pq.peek() < K) return -1;

      int cook1 = pq.peek();
      pq.poll();
      int cook2 = pq.peek();
      pq.poll();

      pq.add(cook1 + 2 * cook2);
      time++;
    }
    }
}