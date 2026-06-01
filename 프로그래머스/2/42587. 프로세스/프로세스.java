import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int pri : priorities) {
      pq.add(pri);
    }

    int l = 0;
    while (!pq.isEmpty()) {
      int cur = pq.peek();
      for (int i = 0; i < priorities.length; i++) {
        if (l == location + 1) return answer;
        if (l + i >= priorities.length) {
          if (cur == priorities[l + i - priorities.length]) {
            answer++;
            pq.poll();
            l = l + i - priorities.length + 1;
            break;
          }
        } else {
          if (cur == priorities[l + i]) {
            answer++;
            pq.poll();
            l = l + i + 1;
            break;
          }
        }
      }
    }

    
    return answer;
    }
}