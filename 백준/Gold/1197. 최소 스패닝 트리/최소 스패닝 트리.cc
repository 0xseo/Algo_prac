#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int find_set(int a, vector<int>& parent) {
  if (parent[a] == a) return a;
  parent[a] = find_set(parent[a], parent);
  return parent[a];
}

void union_set(int a, int b, vector<int>& parent) {
  int rootA = find_set(a, parent);
  int rootB = find_set(b, parent);
  if (rootA != rootB) {
    parent[rootA] = rootB;
  }
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int V, E;
  cin >> V >> E;

  struct Compare{
    bool operator()(const vector<long long>& e1, const vector<long long>& e2) {
      return e1[0] > e2[0];
    }
  };
  priority_queue<vector<long long>, vector<vector<long long>>, Compare> pq;

  for (int i = 0; i < E; i++) {
    int a, b;
    long long c;
    cin >> a >> b >> c;

    pq.push({c, a, b});
  }

  vector<int> parent(V+1);
  for (int i = 1; i<= V; i++) parent[i] = i;

  long long weight = 0;
  while (!pq.empty()) {
    long long cost = pq.top()[0];
    int a = pq.top()[1];
    int b = pq.top()[2];
    pq.pop();

    if (find_set(a, parent) != find_set(b, parent)) {
      union_set(a, b, parent);
      weight += cost;
    }
  }

  cout << weight << "\n";

  return 0;
}