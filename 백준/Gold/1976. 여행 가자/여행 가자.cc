#include <iostream>
#include <vector>

using namespace std;

int find_set(int a, vector<int>& parent) {
  if (parent[a] == a) return a;
  parent[a] = find_set(parent[a], parent);
  return parent[a];
}

void union_set(int a, int b, vector<int>& parent) {
  if (find_set(a, parent) != find_set(b, parent)) {
    parent[find_set(a, parent)] = find_set(b, parent);
  }
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int n, m;
  cin >> n >> m;

  vector<int> parent(n+1);
  for (int i = 1; i <= n; i++) parent[i] = i;

  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      int connected;
      cin >> connected;
      if (i == j) continue;
      if (connected) union_set(i, j, parent);
    }
  }

  bool flag = true;
  int city, prevcity;
  for (int i = 0; i < m; i++) {
    if (i == 0) cin >> prevcity;
    else {
      cin >> city;
      if (find_set(city, parent) != find_set(prevcity, parent)) flag = false;
    }
  }

  if (flag) cout << "YES\n";
  else cout << "NO\n";

  return 0;
}