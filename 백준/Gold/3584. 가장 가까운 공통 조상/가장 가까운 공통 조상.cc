#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int T;
  cin >> T;
  for (int t = 0; t < T; t++) {
    int N;
    cin >> N;

    vector<int> depth(N+1);
    vector<int> parents(N+1);
    for (int i = 1; i <= N; i++) parents[i] = i;

    for (int i = 1; i < N; i++) {
      int a, b;
      cin >> a >> b;

      parents[b] = a;
    }

    int root = 0;
    for (int i = 1; i <= N; i++) {
      if (parents[i] == i) {
        root = i;
        depth[i] = 1;
        break;
      } 
    }

    int targetA, targetB;
    cin >> targetA >> targetB;

    for (int i = 1; i <= N; i++) {
      if (i == root) continue;
      int cur = i;
      int d = 0;
      while (depth[parents[cur]] == 0) {
        cur = parents[cur];
        d++;
      }
      depth[i] = depth[parents[cur]] + d + 1;
    }

    if (depth[targetA] != depth[targetB]) {
      if (depth[targetA] < depth[targetB]) {
        int temp = targetA;
        targetA = targetB;
        targetB = temp;
      }

      while (depth[targetA] > depth[targetB]) {
        targetA = parents[targetA];
      }
    }
    while (targetA != targetB) {
      targetA = parents[targetA];
      targetB = parents[targetB];
    }
    cout << targetA << "\n";

  }
  return 0;
}