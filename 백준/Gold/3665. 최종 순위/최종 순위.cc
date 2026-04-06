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

  for (int t = 0; t < T; t++) {
    int n;
    cin >> n;

    vector<int> indeg(n+1, 0);
    vector<int> outdeg[n+1];

    int lastYear[n+1];
    int orderByLastYear[n+1];
    for (int i = 1; i <= n; i++) {
      cin >> orderByLastYear[i];
      lastYear[orderByLastYear[i]] = i;
    }

    // i는 성적
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i-1; j++) indeg[orderByLastYear[i]]++;
      for (int j = i+1; j <= n; j++) outdeg[orderByLastYear[i]].emplace_back(orderByLastYear[j]);
    }

    int m;
    cin >> m;
    for (int i = 0; i < m; i++) {
      int a, b;
      cin >> a >> b;

      if (lastYear[a] > lastYear[b]) {
        int temp = a;
        a = b;
        b = temp;
      }


      // a팀이 뒤로 가야 함
      indeg[b]--;
      indeg[a]++;

      outdeg[b].emplace_back(a);
      outdeg[a].erase(remove(outdeg[a].begin(), outdeg[a].end(), b));
    }


    queue<int> q;
    queue<int> visited;
    for (int i = 1; i <= n; i++) {
      if (indeg[i] == 0) q.push(i);
    }

    vector<int> ans;
    while (!q.empty()) {
      if (q.size() > 1) {
        break;
      }
      int now = q.front();
      q.pop();

      ans.emplace_back(now);
      visited.push(now);

      for (int toNode: outdeg[now]) {
        indeg[toNode]--;
        if (indeg[toNode] == 0) q.push(toNode);
      }      
    }

    if (q.size() > 1) cout << "?\n";
    else if (visited.size() < n) cout << "IMPOSSIBLE\n";
    else {
      for (int i = 0; i < n; i++) {
        cout << ans[i] << " ";
      }
      cout << "\n";
    }
  }

  return 0;
}
