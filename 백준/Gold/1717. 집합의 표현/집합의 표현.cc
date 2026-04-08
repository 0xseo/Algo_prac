#include <iostream>
#include <vector>

using namespace std;

int find_set(int a, vector<int>& parent) {
  if (parent[a] == a) return a;
  else {
    parent[a] = find_set(parent[a], parent);
    return parent[a];
  }
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
  for (int i = 0; i <= n; i++) parent[i] = i;

  for (int q = 0; q < m; q++) {
    int cmd, a, b;
    cin >> cmd >> a >> b;

    if (cmd == 0) union_set(a, b, parent);
    else {
      if (find_set(a, parent) == find_set(b, parent)) cout << "yes\n";
      else cout << "no\n";
    }
  }
  return 0;
}
