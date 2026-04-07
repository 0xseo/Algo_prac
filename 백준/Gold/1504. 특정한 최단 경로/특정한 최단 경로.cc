#include <iostream>
#include <vector>
#include <queue>
#include <cmath>

using namespace std;
using prNodeDistance = pair<int, long long>;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int N, E;
  long long inf = 9e9;
  cin >> N >> E;

  vector<prNodeDistance> edges[N+1];

  for (int i = 0; i < E; i++) {
    int u, v, w;
    cin >> u >> v >> w;

    edges[u].emplace_back(v, w);
    edges[v].emplace_back(u, w);
  }

  int v1, v2;
  cin >> v1 >> v2;

  struct Compare {
    bool operator()(const prNodeDistance &e1, const prNodeDistance &e2) {
      return e1.second > e2.second;
    }
  };
  priority_queue<prNodeDistance, vector<prNodeDistance>, Compare> pq;
  vector<long long> distFrom1(N+1, inf);
  vector<long long> distFromv1(N+1, inf);
  vector<long long> distFromv2(N+1, inf);

  distFrom1[1] = 0;
  pq.push({1, 0});

  while (!pq.empty()) {
    int next = pq.top().first;
    long long d = pq.top().second;
    pq.pop();

    for (prNodeDistance edge : edges[next]) {
      if (distFrom1[next] < d) continue;
      if (distFrom1[edge.first] > d + edge.second) {
        distFrom1[edge.first] = d + edge.second;
        pq.push({edge.first, d + edge.second});
      }
    }
  }

  distFromv1[v1] = 0;
  pq.push({v1, 0});

  while (!pq.empty()) {
    int next = pq.top().first;
    long long d = pq.top().second;
    pq.pop();

    for (prNodeDistance edge:edges[next]) {
      if (distFromv1[next] < d) continue;
      if (distFromv1[edge.first] > d + edge.second) {
        distFromv1[edge.first] = d + edge.second;
        pq.push({edge.first, d + edge.second});
      }
    }
  }

  distFromv2[v2] = 0;
  pq.push({v2, 0});

  while (!pq.empty()) {
    int next = pq.top().first;
    long long d = pq.top().second;
    pq.pop();

    for (prNodeDistance edge:edges[next]) {
      if (distFromv2[next] < d) continue;
      if (distFromv2[edge.first] > d + edge.second) {
        distFromv2[edge.first] = d + edge.second;
        pq.push({edge.first, d + edge.second});
      }
    }
  }
  
  long long cost = min(distFrom1[v1] + distFromv1[v2] + distFromv2[N], distFrom1[v2] + distFromv2[v1] + distFromv1[N]);
  if (cost >= inf) cout << "-1\n";
  else cout << cost << "\n";
  return 0;
}