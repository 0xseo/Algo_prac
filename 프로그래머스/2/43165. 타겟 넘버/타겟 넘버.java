import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {numbers[0], 0});
    q.add(new int[] {-numbers[0], 0});

    while (!q.isEmpty()) {
      int num = q.peek()[0];
      int idx = q.peek()[1];
      q.poll();

      if (idx == numbers.length - 1 && num == target) answer++;
      if (idx < numbers.length - 1) {
        q.add(new int[] {num + numbers[idx+1], idx+1});
        q.add(new int[] {num - numbers[idx+1], idx+1});
      }
    }
    return answer;
    }
}