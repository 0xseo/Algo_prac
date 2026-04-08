#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int n, m;
  int inf = 1e9;
  cin >> n >> m;

  vector<int> dist[n+1];
  for (int i = 1; i <= n; i++) {
    for (int j = 0; j <= n; j++) {
      dist[i].push_back(inf);
    }
  }
  for (int i = 1; i <= n; i++) {
    dist[i][i] = 0;
  }

  for (int i = 0; i < m; i++) {
    int a, b, c;
    cin >> a >> b >> c;

    dist[a][b] = dist[a][b] > c ? c : dist[a][b];
  }

  for (int k = 1; k <= n; k++) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (dist[i][k] + dist[k][j] < dist[i][j]) {
          dist[i][j] = dist[i][k] + dist[k][j];
        }
      }
    }
  }

  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      if (dist[i][j] == inf) cout << "0 ";
      else cout << dist[i][j] << " ";
    }
    cout << "\n";
  }

  return 0;
}