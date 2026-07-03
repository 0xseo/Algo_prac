import java.util.*;
class Solution {
    static int cnt = 0;
    static int[] selected;
    static int[] target;
    static int answer = 0;
    public int solution(String word) {
        selected = new int[5];
        target = new int[5];
        for (int i = 0; i < word.length(); i++) {
          if (word.charAt(i) == 'A') target[i] = 1;
          else if (word.charAt(i) == 'E') target[i] = 2;
          else if (word.charAt(i) == 'I') target[i] = 3;
          else if (word.charAt(i) == 'O') target[i] = 4;
          else if (word.charAt(i) == 'U') target[i] = 5;
        }
        dfs(5, 0);
        return answer;
    }
    void dfs(int n, int depth) {
        if (n == depth) {
          boolean turn = true;
          for (int i = 0; i < n; i++) {
            if (selected[i] != target[i]) {
              turn = false;
              break;
            }
          }
          if (turn) answer = cnt;
          cnt++;
          return;
        }
        if (answer == 0) {
          for (int i = 0; i < 6; i++) {
            selected[depth] = i;
            if (i == 0 && depth < n) {
              for (int j = depth; j < n; j++) selected[j] = 0;
              dfs(n, 5);
            } else dfs(n, depth+1);
          }
        }
    }
}