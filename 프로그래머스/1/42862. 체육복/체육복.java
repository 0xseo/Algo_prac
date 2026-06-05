class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
    int[] cnt = new int[n+2];
    for (int i = 0; i < n+2; i++) {
      cnt[i] = 1;
    }
    for (int i : lost) {
      cnt[i] -= 1;
    }
    for (int i : reserve) {
      cnt[i] += 1;
    }

    for (int i = 1; i <= n; i++) {
      if (cnt[i] == 0) {
        if (cnt[i-1] == 2 && cnt[i+1] == 1) {
          cnt[i]++;
          cnt[i-1]--;
        } else if (cnt[i-1] == 1 && cnt[i+1] == 2) {
          cnt[i]++;
          cnt[i+1]--;
        }
      }
    }
    for (int i = 1; i <= n; i++) {
      if (cnt[i] == 0) {
        if (cnt[i-1] == 2) {
          answer++;
        } else if (cnt[i+1] == 2) {
          answer++;
          cnt[i+1]--;
        }
      } else {
        answer++;
      }
    }
    return answer;
    }
}