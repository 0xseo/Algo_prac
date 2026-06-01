import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> s = new Stack<>();
    for (int n : arr) {
      if (s.empty() || s.peek() != n) {
        s.push(n);
      }
    }
    int[] answer = new int[s.size()];
    for (int i = s.size()-1; i >= 0; i--) {
      answer[i] = s.pop();
    }

    return answer;
    }
}