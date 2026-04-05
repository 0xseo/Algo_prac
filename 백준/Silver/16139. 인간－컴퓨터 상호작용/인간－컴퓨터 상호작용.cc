#include <iostream>
#include <string>
#include <vector>

using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  string word;
  int cnt;
  cin >> word >> cnt;

  vector<int> alphabetPos[26];
  int aPos = (int) 'a';
  for (int i = 0; i < word.length(); i++) {
    alphabetPos[(int) (word.at(i)) - aPos].emplace_back(i);
  }

  for (int q = 0; q < cnt; q++) {
    char cmd;
    int l, r;
    cin >> cmd >> l >> r;

    int qIndex = (int) cmd - aPos;
    int cnt = 0;
    for (int i = 0; i < alphabetPos[qIndex].size(); i++) {
      if (l <= alphabetPos[qIndex].at(i) && alphabetPos[qIndex].at(i) <= r) cnt++;
    }
    cout << cnt << "\n";

  }


  return 0;
}