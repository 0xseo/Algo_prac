#include <iostream>
#include <vector>
#include <queue>

using namespace std;

typedef pair<int, int> road;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int n, m;
  cin >> n >> m;

  int maxv = 0;
  priority_queue<road, vector<road>, greater<road>> pq;
  vector<road> connectedFrom[n+1];
  vector<bool> visited(n+1);

  long long totalCost = 0;
  for (int i = 0; i < m; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    connectedFrom[a].push_back({c, b});
    connectedFrom[b].push_back({c, a});
  }

  for (int i = 0; i < connectedFrom[1].size(); i++) {
    pq.push({connectedFrom[1][i].first, connectedFrom[1][i].second});
  }
  visited[1] = true;

  while (!pq.empty()) {
    int cost = pq.top().first;
    int city = pq.top().second;
    pq.pop();

    if (!visited[city]) {
      visited[city] = true;
      totalCost += cost;
      maxv = maxv > cost ? maxv : cost;

      for (const auto& edge : connectedFrom[city]) {
        if (!visited[edge.second]) {
          pq.push({edge.first, edge.second});
        }
      }
    }
  }
  cout << totalCost - maxv << "\n";
  return 0;
}