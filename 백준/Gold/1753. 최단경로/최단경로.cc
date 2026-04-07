#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int V, E, start;
  cin >> V >> E >> start;
  int inf = 1e9;

  vector<int> dist(V+1, inf);
  struct Compare {
    bool operator() (const vector<int> &e1, const vector<int> &e2) {
      return e1[0] > e2[0];
    }
  };
  priority_queue<vector<int>, vector<vector<int>>, Compare> pq;
  vector<int> edgesByNode[V+1];
  int edges[E][2];

  for (int i = 0; i < E; i++) {
    int u, v, w;
    cin >> u >> v >> w;

    edges[i][0] = v;
    edges[i][1] = w;
    edgesByNode[u].emplace_back(i);
  }
  dist[start] = 0;
  vector<int> temp = {0, start};
  pq.push(temp);

  while (!pq.empty()) {
    int d = pq.top()[0];
    int node = pq.top()[1];
    pq.pop();

    if (dist[node] < d) continue;
    for (int edge: edgesByNode[node]) {
      if (dist[edges[edge][0]] > d + edges[edge][1]) {
        dist[edges[edge][0]] = d + edges[edge][1];
        vector<int> temp = {dist[edges[edge][0]], edges[edge][0]};
        pq.push(temp);
      }
    }
  }

  for (int i = 1; i <= V; i++) {
    if (dist[i] == inf) cout << "INF\n";
    else cout << dist[i] << "\n";
  }

  return 0;
}