#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int N;
  cin >> N;

  priority_queue<int> pq;
  for (int i = 0; i < N; i++) {
    int cmd;
    cin >> cmd;

    if (cmd == 0) {
      if (pq.size() == 0) cout << "0\n";
      else {
        cout << pq.top() << "\n";
        pq.pop();
      }
    } else {
      pq.push(cmd);
    }
  }

  return 0;
}