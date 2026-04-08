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

  int cnt = -1;

  vector<int> parent(n);
  for (int i = 0; i < n; i++) parent[i] = i;

  for (int turn = 0; turn < m; turn++) {
    int a, b;
    cin >> a >> b;

    if (find_set(a, parent) != find_set(b, parent)) union_set(a, b, parent);
    else {
      cnt = turn;
      break;
    }

  }
  if (cnt == -1) cout << "0\n";
  else cout << cnt+1 << "\n";
  return 0;
}