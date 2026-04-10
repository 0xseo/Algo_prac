#include <iostream>
#include <vector>
#include <queue>

using namespace std;
typedef pair<int, int> edge;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int N; cin >> N;

  vector<int> connectedNode[N+1];
  vector<vector<int>> parents(17);
  vector<int> depth(N+1);
  depth[1] = 1;

  for (int i = 0; i < 17; i++) {
    for (int j = 0; j <= N; j++) {
      parents[i].push_back(0);
    }
  }
  parents[0][1] = 1;

  for (int i = 1; i < N; i++) {
    int a, b;
    cin >> a >> b;
    connectedNode[a].emplace_back(b);
    connectedNode[b].emplace_back(a);
  }

  queue<edge> q;
  for (int i = 0; i < connectedNode[1].size(); i++) {
    q.push({connectedNode[1][i], 1});
  }

  while (!q.empty()) {
    int node = q.front().first;
    int parent = q.front().second;
    q.pop();

    depth[node] = depth[parent] + 1;
    parents[0][node] = parent;

    for (int toNode: connectedNode[node]) {
      if (depth[toNode] == 0) {
        q.push({toNode, node});
      }
    }
  }

  for (int i = 1; i < 17; i++) {
    for (int j = 1; j <= N; j++) {
      parents[i][j] = parents[i-1][parents[i-1][j]];
    }
  }

  int M; cin >> M;
  for (int i = 0; i < M; i++) {
    int a, b; cin >> a >> b;

    if (depth[a] < depth[b]) {
      int temp = a;
      a = b;
      b = temp;
    }

    int diff = depth[a] - depth[b];
    // a가 b의 depth까지 올라가야 함
    for (int k = 0; diff > 0; k++) {
      if (diff & (1 << k)) {
        a = parents[k][a];
        diff &= ~(1 << k);
      }
    }
    if (a == b) {
      cout << a << "\n";
      continue;
    }
    int depthBit = -1;
    int curDepth = depth[a];
    while (curDepth > 0) {
      depthBit++;
      curDepth >>= 1;
    }
    for (int k = depthBit; k >= 0; k--) {
      if (parents[k][a] != parents[k][b]) {
        a = parents[k][a];
        b = parents[k][b];
      }
    }

    cout << parents[0][a] << "\n";
  }
  return 0;
}