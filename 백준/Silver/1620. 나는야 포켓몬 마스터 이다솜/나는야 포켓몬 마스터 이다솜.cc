#include <iostream>
#include <map>
#include <string>
#include <algorithm>

using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int N, M;
  cin >> N >> M;

  map<string, int> mapByString;
  vector<string> mapByInt;

  for (int i = 0; i < N; i++) {
    string name;
    cin >> name;
    mapByInt.emplace_back(name);
    mapByString.insert({name, i+1});
  }

  for (int i = 0; i < M; i++) {
    string cmd;
    cin >> cmd;
    if (all_of(cmd.begin(), cmd.end(), ::isdigit)) cout << mapByInt.at(stoi(cmd)-1) << "\n";
    else cout << mapByString[cmd] << "\n";
  }
  return 0;
}