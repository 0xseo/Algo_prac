#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int m; cin >> m;

  vector<vector<int>> parents(20);
  for (int i = 0; i < 20; i++) {
    parents[i].emplace_back(0);
    for (int mm = 1; mm <= m; mm++) {
      if (i == 0) {
        int v;
        cin >> v;
        parents[i].emplace_back(v);
      } else {
        parents[i].emplace_back(parents[i-1][parents[i-1][mm]]);
      }
    }
  }

  int q; cin >> q;
  for (int query = 0; query < q; query++) {
    int n, x; cin >> n >> x;

    for (int i = 0; n > 0; i++) {
      if (n & (1 << i)) {
        x = parents[i][x];
        n &= ~(1 << i);
      }
    }
    cout << x << "\n";
  }
  return 0;
}