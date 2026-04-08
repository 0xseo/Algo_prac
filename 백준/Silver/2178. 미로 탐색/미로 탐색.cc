#include <iostream>
#include <vector>
#include <string>
#include <queue>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  // bfs
  int N, M;
  cin >> N >> M;
  int inf = 1e9;

  vector<int> dist[N];
  vector<int> map[N];
  int dy[4] = {-1, 1, 0, 0};
  int dx[4] = {0, 0, -1, 1};

  for (int i = 0; i < N; i++) {
    string temp;
    cin >> temp;

    for (int j = 0; j < M; j++) {
      map[i].emplace_back((int) temp.at(j) - (int) '0');
      dist[i].emplace_back(inf);
    }
  }
  dist[0][0] = 1;

  queue<vector<int>> q;
  q.push({0, 0, 1});

  while (!q.empty()) {
    int y = q.front()[0];
    int x = q.front()[1];
    int cost = q.front()[2];
    q.pop();

    if (y == N-1 && x == M-1) break;
    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if (0 <= ny && ny < N && 0 <= nx && nx < M) {
        if (map[ny][nx] == 0) continue;
        if (dist[ny][nx] > cost + 1) {
          dist[ny][nx] = cost + 1;
          q.push({ny, nx, cost+1});
        }
      }
    }
  }

  cout << dist[N-1][M-1] << "\n";

  return 0;
}