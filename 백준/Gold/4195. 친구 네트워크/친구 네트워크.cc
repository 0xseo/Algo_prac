#include <iostream>
#include <vector>
#include <map>
#include <string>

using namespace std;

int find_set(int a, vector<int>& parent) {
  if (parent[a] == a) return a;
  parent[a] = find_set(parent[a], parent);
  return parent[a];
}

void union_set(int a, int b, vector<int>& parent, vector<int>& set_size) {
  int rootA = find_set(a, parent);
  int rootB = find_set(b, parent);
  if (rootA != rootB) {
    parent[rootA] = rootB;
    set_size[rootB] += set_size[rootA];
  }
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int T;
  cin >> T;

  for (int t = 0; t < T; t++) {
    int F;
    cin >> F;

    map<string, int> userId;
    int total = 0;
    vector<int> parent;
    vector<int> set_size;

    for (int i = 0; i < F; i++) {
      string name1, name2;
      int p1, p2;
      cin >> name1 >> name2;

      if (userId.find(name1) == userId.end()) {
        p1 = total;
        userId.insert({name1, p1});
        parent.emplace_back(p1);
        set_size.emplace_back(1);
        total++;
      } else {
        p1 = userId.find(name1)->second;
      }
      if (userId.find(name2) == userId.end()) {
        p2 = total;
        userId.insert({name2, p2});
        parent.emplace_back(p2);
        set_size.emplace_back(1);
        total++;
      } else {
        p2 = userId.find(name2)->second;
      }
      union_set(p1, p2, parent, set_size);
      cout << set_size[find_set(p1, parent)] << "\n";
    }
  }
  return 0;
}