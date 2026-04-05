#include <iostream>
#include <set>
#include <string>

using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  string S;
  set<string> s;
  cin >> S;

  for (int i = 1; i <= S.length(); i++) {
    for (int j = 0; j < S.length() - i + 1; j++) {
      s.insert(S.substr(j, i));
    }
  }

  cout << s.size() << "\n";

  return 0;
}