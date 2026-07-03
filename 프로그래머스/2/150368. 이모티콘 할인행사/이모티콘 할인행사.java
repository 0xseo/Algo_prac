import java.util.*;
class Solution {
    static int[] selected;
  static int maxSubs;
  static int maxMoney;
  static int[][] us;
  static int[] em;
  public int[] solution(int[][] users, int[] emoticons) {
    int n = emoticons.length;
    selected = new int[n];
    maxMoney = 0;
    maxSubs = 0;
    us = users;
    em = emoticons;

    dfs(n, 0);

    return new int[] {maxSubs, maxMoney};
  }

  void dfs(int n, int depth) {
    if (depth == n) {

      int curSubs = 0;
      int curMoney = 0;
      for (int i = 0; i < us.length; i++) {
        int curUserMoney = 0;
        for (int emoticon = 0; emoticon < n; emoticon++) {
          if (selected[emoticon] * 10 >= us[i][0]) {
            // System.out.println("user" + i + " bought em[" + emoticon + "]");
            curUserMoney += (em[emoticon] * (100 - (selected[emoticon] * 10))) / 100;
          }
        }
        if (curUserMoney >= us[i][1]) {
          curSubs++;
          // System.out.println("user" + i + " subscribe");
        }
        else {
          curMoney += curUserMoney;
          // System.out.println("user" + i + " didn't subscribe but paid " + curUserMoney);
        }
      }
      if (maxSubs < curSubs) {
        maxSubs = curSubs;
        maxMoney = curMoney;
      } else if (maxSubs == curSubs) {
        maxMoney = Math.max(maxMoney, curMoney);
      }
      return;
    }
    for (int j = 1; j <= 4; j++) {
      selected[depth] = j;
      dfs(n, depth+1);
    }
  }
}