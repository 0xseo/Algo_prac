#include <iostream>
#include <string>

using namespace std;
int alphabetCnt[26][200001];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  string word;
  int cnt;
  cin >> word >> cnt;

  int aPos = (int) 'a';
  for (int i = 0; i < word.length(); i++) {
    int charPos = (int) (word.at(i)) - aPos;
    if (i == 0) alphabetCnt[charPos][i] = 1;
    else {
      for (int j = 0; j < 26; j++) {
        alphabetCnt[j][i] = alphabetCnt[j][i-1];
        if (charPos == j) alphabetCnt[j][i]++;
      }
    }
  }


  for (int q = 0; q < cnt; q++) {
    char cmd;
    int l, r;
    cin >> cmd >> l >> r;

    int qPos = (int) cmd - aPos;

    int toSub;
    if (l == 0) toSub = 0;
    else toSub = alphabetCnt[qPos][l - 1];

    cout << alphabetCnt[qPos][r] - toSub << "\n";

  }


  return 0;
}