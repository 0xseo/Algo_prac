#include <iostream>
#include <vector>
#include <queue>
#include <cmath>

using namespace std;
typedef pair<int, int> edge;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int N; cin >> N;

  // tree build를 위한 node별 연결 도로 (toNode, cost)
  vector<edge> connectedNodes[N+1];
  // sparse tree for parents (N < 2^17)
  vector<vector<int>> parents(17);
  // sparse tree for cost
  vector<vector<int>> costsMin(17);
  vector<vector<int>> costsMax(17);
  for (int i = 0; i < 17; i++) {
    for (int j = 0; j <= N; j++) {
      parents[i].push_back(0);
      costsMin[i].push_back(1e9);
      costsMax[i].push_back(0);
    }
  }
  vector<int> depth(N+1);

  for (int i = 1; i < N; i++) {
    int a, b, c; cin >> a >> b >> c;
    connectedNodes[a].push_back({b, c});
    connectedNodes[b].push_back({a, c});
  }

  // tree build (depth 계산)
  queue<vector<int>> q;
  // root(1번 노드)에 연결된 모든 도로 q에 push
  for (int i = 0; i < connectedNodes[1].size(); i++) {
    q.push({connectedNodes[1][i].first, connectedNodes[1][i].second, 1});
  }
  depth[1] = 1;
  parents[0][1] = 1;

  while (!q.empty()) {
    int toNode = q.front()[0];
    int cost = q.front()[1];
    int parent = q.front()[2];
    q.pop();

    parents[0][toNode] = parent;
    costsMin[0][toNode] = cost;
    costsMax[0][toNode] = cost;
    depth[toNode] = depth[parent] + 1;

    // toNode의 자식 중 아직 방문하지 않은 자식들 q에 push
    for (const auto& road: connectedNodes[toNode]) {
      if (depth[road.first] == 0) {
        q.push({road.first, road.second, toNode});
      }
    }
  }

  // sparse tree 업데이트
  for (int i = 1; i < 17; i++) {
    for (int j = 1; j <= N; j++) {
      parents[i][j] = parents[i-1][parents[i-1][j]];
      costsMin[i][j] = min(costsMin[i-1][j], costsMin[i-1][parents[i-1][j]]);
      costsMax[i][j] = max(costsMax[i-1][j], costsMax[i-1][parents[i-1][j]]);
    }
  }

  // for (int i = 0; i < 17; i++) {
  //   for (int j = 1; j <= N; j++) {
  //     cout << costsMin[i][j] << " ";
  //   }
  //   cout << "\n";
  // }

  // query input 받기
  int K; cin >> K;
  for (int query = 0; query < K; query++) {
    int d, e; cin >> d >> e;

    int minCost = 1e9;
    int maxCost = 0;

    if (depth[d] != depth[e]) {
      // 우선 두 노드의 depth를 맞춰준다 (d가 더 올라가야 함)
      if (depth[d] < depth[e]) {
        int temp = d;
        d = e;
        e = temp;
      }

      // 2진수(bit)로 표기해서 부모로 올리기
      int diff = depth[d] - depth[e];
      for (int k = 0; diff > 0; k++) {
        if (diff & (1 << k)) {
          // 값은 그 도로 중 최대/최소 비용으로 업데이트
          minCost = min(minCost, costsMin[k][d]);
          maxCost = max(maxCost, costsMax[k][d]);
          d = parents[k][d];
          diff &= ~(1 << k);
        }
      }
    }

    if (d == e) {
      // e가 d의 조상이었던 경우
      cout << minCost << " " << maxCost << "\n";
      continue;
    }

    // depth가 같아졌으니 이제 depth의 bit수 ~ 0 확인하면서
    // 공통 조상이 아닐 경우 올라가기
    int leftDepth = depth[d];
    int bitCount = -1;
    while (leftDepth > 0) {
      bitCount++;
      leftDepth >>= 1;
    }

    for (int k = bitCount; k >= 0; k--) {
      if (parents[k][d] != parents[k][e]) {
        minCost = min(minCost, min(costsMin[k][d], costsMin[k][e]));
        maxCost = max(maxCost, max(costsMax[k][d], costsMax[k][e]));
        d = parents[k][d];
        e = parents[k][e];
      }
    }

    // 마지막으로 한 칸 더 올라가면 최소 공통 조상
    minCost = min(minCost, min(costsMin[0][d], costsMin[0][e]));
    maxCost = max(maxCost, max(costsMax[0][d], costsMax[0][e]));

    cout << minCost << " " << maxCost << "\n";
  }
}