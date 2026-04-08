#include <iostream>
#include <vector>
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

  int Hx, Hy, Ex, Ey;
  // y x 바뀜 주의
  cin >> Hy >> Hx >> Ey >> Ex;

  vector<int> map[N];
  vector<vector<int>> dist[N];
  int dy[] = {-1, 1, 0, 0};
  int dx[] = {0, 0, -1, 1};


  for (int i = 0; i < N; i++) {
    for (int j = 0; j < M; j++) {
      int space;
      cin >> space;
      map[i].emplace_back(space);
      dist[i].push_back({inf, inf});
    }
  }

  queue<vector<int>> q;
  dist[Hy-1][Hx-1][0] = 0;
  dist[Hy-1][Hx-1][1] = 0;
  q.push({Hy-1, Hx-1, 0});

  while (!q.empty()) {
    int y = q.front()[0];
    int x = q.front()[1];
    int useWand = q.front()[2];
    q.pop();

    // 도착했으면 더 이상 볼 필요는 없음
    if (y == Ey-1 && x == Ex-1) break;
    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if (0 <= ny && ny < N && 0 <= nx && nx < M) {
        // 벽이고 이미 지팡이를 썼음 = 더 이상 못감
        if (map[ny][nx] == 1 && useWand == 1) continue;
        if (dist[ny][nx][useWand] > dist[y][x][useWand]+1) {

          // 벽이고 이번에 지팡이를 씀
          if (map[ny][nx] == 1) {
            dist[ny][nx][1] = dist[y][x][0] + 1;
            q.push({ny, nx, 1});
          }
          // 벽이 아님 (지팡이 여부는 이전과 똑같음)
          else {
            dist[ny][nx][useWand] = dist[y][x][useWand]+1;
            q.push({ny, nx, useWand});
          }
        }
      }
    }
  }

  if (dist[Ey-1][Ex-1][0] == inf && dist[Ey-1][Ex-1][1] == inf) cout << "-1\n";
  else {
    int d = dist[Ey-1][Ex-1][0] < dist[Ey-1][Ex-1][1] ? dist[Ey-1][Ex-1][0] : dist[Ey-1][Ex-1][1];
    cout << d << "\n";
  }

  return 0;
}