#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int T;
  cin >> T;

  for (int i = 0; i < T; i++) {
    int n, m, t, s, g, h;
    cin >> n >> m >> t >> s >> g >> h;

    int inf = 8e9;
    vector<long long> distFromS(n+1, inf);
    vector<long long> distFromG(n+1, inf);
    vector<long long> distFromH(n+1, inf);
    vector<vector<int>> edges[n+1];
    int watchedRoadCost = 0;

    for (int j = 0; j < m; j++) {
      int a, b, d;
      cin >> a >> b >> d;

      edges[a].push_back({b, d});
      edges[b].push_back({a, d});
    }

    struct Compare {
      bool operator() (const vector<long long> &e1, const vector<long long> &e2) {
        return e1[1] > e2[1];
      }
    };
    priority_queue<vector<long long>, vector<vector<long long>>, Compare> pq;
    pq.push({s, 0});

    while (!pq.empty()) {
      int next = pq.top()[0];
      long long cost = pq.top()[1];
      pq.pop();

      if (distFromS[next] > cost) {
        distFromS[next] = cost;

        for (vector<int> edge : edges[next]) {
          if (distFromS[edge[0]] > cost + edge[1]) {
            pq.push({edge[0], cost + edge[1], next});
          }
        }
      }
    }

    pq.push({g, 0});

    while (!pq.empty()) {
      int next = pq.top()[0];
      long long cost = pq.top()[1];
      pq.pop();

      if (distFromG[next] > cost) {
        distFromG[next] = cost;

        for (vector<int> edge : edges[next]) {
          if (distFromG[edge[0]] > cost + edge[1]) {
            pq.push({edge[0], cost + edge[1], next});
          }
        }
      }
    }

    pq.push({h, 0});

    while (!pq.empty()) {
      int next = pq.top()[0];
      long long cost = pq.top()[1];
      pq.pop();

      if (distFromH[next] > cost) {
        distFromH[next] = cost;

        for (vector<int> edge : edges[next]) {
          if (distFromH[edge[0]] > cost + edge[1]) {
            pq.push({edge[0], cost + edge[1], next});
          }
        }
      }
    }

    watchedRoadCost = distFromG[h];

    vector<int> ans;
    for (int j = 0; j < t; j++) {
      int candidate;
      cin >> candidate;

      if (distFromS[candidate] == distFromS[g] + watchedRoadCost + distFromH[candidate] || distFromS[candidate] == distFromS[h] + watchedRoadCost + distFromG[candidate]) {
        ans.emplace_back(candidate);
      }
    }

    sort(ans.begin(), ans.end());

    for (int cand : ans) {
      cout << cand << " ";
    }
    cout << "\n";
  }
  return 0;
}