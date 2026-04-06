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

  vector<int> indeg(N + 1, 0);
  vector<int> outdeg[N+1];
  for (int i = 0; i < M; i++) {
    int a, b;
    cin >> a >> b;

    indeg[b]++;
    outdeg[a].emplace_back(b);
  }

  queue<int> q;

  for (int i = 1; i <= N; i++) {
    if (indeg[i] == 0) q.push(i);
  }

  while (!q.empty()) {
    int now = q.front();
    q.pop();
    cout << now << " ";

    for (int toNode : outdeg[now]) {
      indeg[toNode]--;
      if (indeg[toNode] == 0) q.push(toNode);
    }
  }
  cout << "\n";

  return 0;
}