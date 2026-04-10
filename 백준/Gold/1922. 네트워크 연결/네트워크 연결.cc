#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int find_set(int a, vector<int>& parents) {
  if (parents[a] == a) return a;
  parents[a] = find_set(parents[a], parents);
  return parents[a];
}

void union_set(int a, int b, vector<int>& parents) {
  int rootA = find_set(a, parents);
  int rootB = find_set(b, parents);
  if (rootA != rootB) {
    parents[rootA] = rootB;
  }
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int N, M;
  cin >> N >> M;

  vector<int> parents(N+1);
  for (int i = 1; i <= N; i++) parents[i] = i;
  struct Compare {
    bool operator() (const vector<int>& e1, const vector<int>& e2) {
      return e1[0] > e2[0];
    }
  };
  priority_queue<vector<int>, vector<vector<int>>, Compare> pq;

  for (int i = 0; i < M; i++) {
    int a, b, c;
    cin >> a >> b >> c;

    if (a != b) {
      pq.push({c, a, b});
    }
  }

  int cost = 0;
  while (!pq.empty()) {
    int c = pq.top()[0];
    int a = pq.top()[1];
    int b = pq.top()[2];
    pq.pop();

    if (find_set(a, parents) != find_set(b, parents)) {
      cost += c;
      union_set(a, b, parents);
    }
  }

  cout << cost << "\n";
  return 0;
}