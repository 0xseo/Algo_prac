#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  // dfs
  // 전위 순회로 방문하면서 1) 색이 정해져 있지 않거나 2) 직전(부모)와 다르면 ok
  // 색이 직전(부모)와 같으면 impossible

  int T;
  cin >> T;
  for (int t = 0; t < T; t++) {
    int n, m;
    cin >> n >> m;

    vector<int> edges[n+1];
    for (int i = 0; i < m; i++) {
      int x, y;
      cin >> x >> y;

      edges[x].emplace_back(y);
      edges[y].emplace_back(x);
    }

    vector<int> colors(n+1, -1);
    stack<vector<int>> s;

    bool flag = false;
    // 모든 동그라미가 연결되어 있다는 보장이 없기 때문에
    // 색칠이 안된 모든 동그라미에 대해서 BFS 따로 진행
    for (int i = 1; i <= n; i++) {
      if (colors[i] != -1) continue;
      s.push({i, 1}); // node, color
      colors[1] = 1;

      while (!s.empty()) {
        int node = s.top()[0];
        int color = s.top()[1];
        s.pop();

        for (int child : edges[node]) {
          if (colors[child] == color) { // 연결된 동그라미 간 색이 같음
            flag = true;
            break;
          } else if (colors[child] == -1) { // 아직 색이 안정해짐
            colors[child] = ~color;
            s.push({child, colors[child]});
          }
          // 정해졌고 연결된 동그라미 간 색이 다르면 pass
        }
      }
    }

    if (flag) cout << "impossible\n";
    else cout << "possible\n";
  }
  return 0;
}