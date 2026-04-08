#include <iostream>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  // 벨만포드 알고리즘
  // 묘비(src, dest)/귀신구멍(src) 제외 사방향, 귀신 구멍 통한 길 포함해서 edgelist 만들기
  // for H*W) edge 돌면서 최단거리 갱신
  // 한번 더 돌면서 음수 순환 확인 -> Never
  // 도착 가능 여부 확인 -> Impossible or dist[H-1][W-1]

  int inf = 1e9;
  int W, H;
  cin >> W >> H;
  while (W != 0 && H != 0) {
    vector<int> dist[H];
    // map -> -1: 귀신 구멍 / 0: 잔디 / 1: 묘비
    vector<int> map[H];
    vector<vector<int>> edgeList; // {y1, x1, y2, x2, cost}
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        map[i].push_back(0);
        dist[i].push_back(inf);
      }
    }
    dist[0][0] = 0;

    // 묘비
    int G;
    cin >> G;
    for (int i = 0; i < G; i++) {
      int x, y;
      cin >> x >> y;
      map[y][x] = 1;
    }

    // 귀신 구멍 edgeList에 추가
    int E;
    cin >> E;
    for (int i = 0; i < E; i++) {
      int x1, y1, x2, y2, t;
      cin >> x1 >> y1 >> x2 >> y2 >> t;

      edgeList.push_back({y1, x1, y2, x2, t});
      map[y1][x1] = -1;
    }

    // 묘비 제외 사방향 edgeList 만들기
    int dy[4] = {-1, 1, 0, 0};
    int dx[4] = {0, 0, 1, -1};
    for (int y = 0; y < H; y++) {
      for (int x = 0; x < W; x++) {
        if (y == H-1 && x == W-1) continue;
        // 이번 칸이 묘비/귀신 구멍이 아니면
        if (map[y][x] != 1 && map[y][x] != -1) {
          for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0 <= ny && ny < H && 0 <= nx && nx < W) {
              // 다음 칸이 묘비가 아니면
              if (map[ny][nx] != 1) {
                edgeList.push_back({y, x, ny, nx, 1});
              }
            }
          }
        }
      }
    }

    // 벨만포드: 노드 수만큼 edgeList 돌면서 최단거리 갱신
    for (int y = 0; y < H; y++) {
      for (int x = 0; x < W; x++) {
        for (const auto& edge:edgeList) {
          if (y == H-1 && x == W-1) continue;
          // src에도 아직 못 갔으면 continue
          if (dist[edge[0]][edge[1]] == inf) continue;
          if (dist[edge[2]][edge[3]] > dist[edge[0]][edge[1]] + edge[4]) {
            dist[edge[2]][edge[3]] = dist[edge[0]][edge[1]] + edge[4];
          }
        }
      }
    }
    // 한번 더 돌면서 음의 순환 check
    bool check = false;
    for (const auto& edge:edgeList) {
      // src에도 아직 못 갔으면 continue
      if (dist[edge[0]][edge[1]] == inf) continue;
      if (dist[edge[2]][edge[3]] > dist[edge[0]][edge[1]] + edge[4]) {
        check = true;
        break;
      }
    }
    if (check) cout << "Never\n";
    else {
      if (dist[H-1][W-1] == inf) cout << "Impossible\n";
      else cout << dist[H-1][W-1] << "\n";
    }

    cin >> W >> H;
  }

  return 0;
}