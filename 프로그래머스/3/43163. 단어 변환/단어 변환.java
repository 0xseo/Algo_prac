import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int minV = 50;
    HashSet<String> set = new HashSet<>();
    HashSet<String> cands = new HashSet<>();
    for (String w : words) {
      cands.add(w);
    }
    Queue<String[]> q = new LinkedList<>();

    q.add(new String[] {begin, "0"});
    set.add(begin);

    while (!q.isEmpty()) {
      String word = q.peek()[0];
      int num = Integer.parseInt(q.peek()[1]);
      q.poll();

      if (word.equals(target)) {minV = Math.min(minV, num); continue;}

      for (String cand : cands) {
        if (canChange(word, cand) && !set.contains(cand)) {
          q.add(new String[] {cand, Integer.toString(num+1)});
          set.add(cand);
        }
      }
    }
    if (minV == 50) return 0;
    return minV;
  }

  public boolean canChange(String a, String b) {
    int cnt = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) cnt++;
    }
    if (cnt == 1) return true;
    return false;
    }
}