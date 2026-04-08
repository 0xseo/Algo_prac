#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int N, M;
  cin >> N >> M;

  long long inf = 9e9;
  vector<long long> dist(N+1, inf);
  vector<vector<int>> edges;

  for (int i = 0; i < M; i++) {
    int A, B, C;
    cin >> A >> B >> C;

    edges.push_back({A, B, C});
  }
  dist[1] = 0;

  for (int v = 0; v < N; v++) {
    for (vector<int> edge : edges) {
      int src = edge[0];
      int dest = edge[1];
      int cost = edge[2];

      if (dist[src] == inf) continue;
      // dest까지의 거리 = min(dest까지의 거리 vs src까지의 거리 + src->dest 거리)
      dist[dest] = dist[dest] > dist[src] + cost ? dist[src] + cost : dist[dest];
    }
  }
  for (vector<int> edge : edges) {
    int src = edge[0];
    int dest = edge[1];
    int cost = edge[2];

    if (dist[src] == inf) continue;
    if (dist[dest] > dist[src] + cost) {
      cout << "-1\n";
      return 0;
    }
  }
  for (int v = 2; v <= N; v++) {
    if (dist[v] == inf) cout << "-1\n";
    else cout << dist[v] << "\n";
  }
  return 0;
}