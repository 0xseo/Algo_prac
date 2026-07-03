import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int minNum = minerals.length;
    int canPick = 0;
    for (int i = 0; i < 3; i++) canPick += picks[i] * 5;
    int[] energyByDia = new int[minNum / 5 + 1];
    int[] energyByIron = new int[minNum / 5 + 1];
    int[] energyByStone = new int[minNum / 5 + 1];
    int answer = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> {
      if (e1[2] != e2[2]) return e2[2] - e1[2];
      if (e1[1] != e1[1]) return e2[1] - e1[1];
      return e2[0] - e1[0];
    });

    for (int i = 0; i < minNum / 5 + 1; i++) {
      for (int j = 0; j < 5; j++) {
        if (i * 5 + j >= minNum || i * 5 + j > canPick) break;
        String m = minerals[i * 5 + j];
        int e = 1;
        energyByDia[i] += e;
        if (m.equals("diamond")) e *= 5;
        energyByIron[i] += e;
        if (m.equals("diamond")) e *= 5;
        if (m.equals("iron")) e *= 5;
        energyByStone[i] += e;
      }
      pq.offer(new int[] {energyByDia[i], energyByIron[i], energyByStone[i]});
    }

    while (!pq.isEmpty()) {
      int eD = pq.peek()[0];
      int eI = pq.peek()[1];
      int eS = pq.peek()[2];
      pq.poll();
      if (picks[0] != 0) {
        answer += eD;
        picks[0]--;
      } else if (picks[1] != 0) {
        answer += eI;
        picks[1]--;
      } else if (picks[2] != 0) {
        answer += eS;
        picks[2]--;
      }
    }
    return answer;
    }
}