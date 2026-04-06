#include <iostream>
#include <vector>
#include <queue>

using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int N, M;
  cin >> N >> M;

  priority_queue<int, vector<int>, greater<int>> pq;
  vector<int> indeg(N+1, 0);
  vector<int> outdeg[N+1];

  for (int i = 0; i < M; i++) {
    int a, b;
    cin >> a >> b;

    indeg[b]++;
    outdeg[a].emplace_back(b);
  }

  for (int i = 1; i <= N; i++) {
    if (indeg[i] == 0) pq.push(i);
  }

  while (!pq.empty()) {
    int num = pq.top();
    pq.pop();

    cout << num << " ";
    for (int toNode: outdeg[num]) {
      indeg[toNode]--;
      if (indeg[toNode] == 0) pq.push(toNode);
    }
  }
  cout << "\n";

  return 0;
}