#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int V, E;
  cin >> V >> E;
  int inf = 1e9;

  vector<int> dist[V+1];
  for (int i = 1; i <= V; i++) {
    for (int j = 0; j <= V; j++) {
      dist[i].push_back(inf);
    }
  }

  for (int i = 1; i <= V; i++) dist[i][i] = 0;

  for (int i = 0; i < E; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    // dist[a][b] = min(dist[a][b], c)
    dist[a][b] = dist[a][b] < c ? dist[a][b] : c;
  }

  for (int k = 1; k <= V; k++) {
    for (int i = 1; i <= V; i++) {
      for (int j = 1; j <= V; j++) {
        if (dist[i][j] > dist[i][k] + dist[k][j]) {
          dist[i][j] = dist[i][k] + dist[k][j];
        }
      }
    }
  }

  int minv = inf;
  for (int i = 1; i <= V; i++) {
    for (int j = 1; j <= V; j++) {
      if (i == j) continue;
      if (dist[i][j] != inf && dist[j][i] != inf) {
        // minv = min(minv, dist[i][j] + dist[j][i])
        minv = minv > dist[i][j] + dist[j][i] ? dist[i][j] + dist[j][i] : minv;
      }
    }
  }

  if (minv == inf) cout << "-1\n";
  else cout << minv << "\n";

  return 0;
}
