import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int size = N * number + 1;
    int inf = 99999;
    int[] dp = new int[size];
    List<Integer>[] arr = new ArrayList[9];

    for (int turn = 1; turn <= 8; turn++) {
      arr[turn] = new ArrayList<>();
    }
    for (int i = 1; i < size; i++) {
      dp[i] = inf;
    }

    dp[N] = 1;
    arr[1].add(N);

    for (int turn = 2; turn <= 8; turn++) {
      for (int i = 1; i <= turn / 2; i++) {
        for (int j = 0; j < arr[i].size(); j++) {
          for (int k = 0; k < arr[turn - i].size(); k++) {
            int[] cands = new int[6];
            cands[0] = arr[i].get(j) + arr[turn - i].get(k);
            cands[1] = arr[i].get(j) - arr[turn - i].get(k);
            cands[2] = -cands[1];
            cands[3] = arr[i].get(j) * arr[turn - i].get(k);
            cands[4] = arr[i].get(j) / arr[turn - i].get(k);
            cands[5] = arr[turn - i].get(k) / arr[i].get(j);

            for (int c = 0; c < 6; c++) {
              if (cands[c] > 0 && cands[c] < size && dp[cands[c]] == inf) {
                dp[cands[c]] = turn;
                arr[turn].add(cands[c]);
              }
            }
          }
        }
      }
      int NN = Integer.parseInt(Integer.toString(N).repeat(turn));
      if (NN < size) {
        arr[turn].add(NN);
        dp[NN] = turn;
      }
    }
    if (dp[number] > 8) return -1;
    return dp[number];
    }
}