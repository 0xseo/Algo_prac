#include <iostream>
#include <queue>
#include <functional>
#include <vector>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int maxv = 100000;
  int dist[maxv+1];
  int inf = 1e9;
  for (int i = 0; i <= maxv; i++) {
    dist[i] = inf;
  }

  int n, k;
  cin >> n >> k;

  if (n >= k) cout << n - k << "\n";
  else {
    priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
    pq.push({0, n});

    while (!pq.empty()) {
      int now = pq.top()[1];
      int cost = pq.top()[0];
      pq.pop();

      if (now == 0) {
        dist[now] = dist[now] > cost ? cost : dist[now];
        pq.push({cost+1, now+1});
        continue;
      } else if (now > maxv) continue;

      dist[now] = dist[now] > cost ? cost : dist[now];
      if (now == k) break;
      pq.push({cost, 2*now});
      // cout << i-1 << ": " << dist[i-1] << " vs " << cost+1 << "\n";
      if (dist[now-1] > cost + 1) {
        dist[now-1] = cost + 1;
        pq.push({cost+1, now-1});
      }
      
      if (now < maxv) {
        // cout << i+1 << ": " << dist[i+1] << " vs " << cost+1 << "\n";
        if (dist[now+1] > cost + 1) {
          dist[now+1] = cost + 1;
          pq.push({cost+1, now+1});
        }
      }
      
      
    }
    cout << dist[k] << "\n";
  }
  return 0;
}