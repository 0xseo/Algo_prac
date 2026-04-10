#include <iostream>
#include <vector>
#include <queue>
#include <functional>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int T; cin >> T;
  for (int t = 0; t < T; t++) {
    int M; cin >> M;

    priority_queue<int, vector<int>, greater<int>> pqMin;
    priority_queue<int> pqMax;
    vector<int> ans;

    int num; cin >> num;
    pqMax.push(num);
    int midV = num;
    ans.push_back(midV);

    for (int i = 1; i <= (M-1)/2; i++) {
      int num1, num2;
      cin >> num1 >> num2;

      pqMin.push(num1);
      pqMax.push(num2);

      if (pqMin.top() < pqMax.top()) {
        int a = pqMin.top();
        int b = pqMax.top();
        pqMin.pop(); pqMax.pop();
        pqMax.push(a);
        pqMin.push(b);
      }
      
      midV = pqMax.top();
      ans.push_back(midV);
    }

    cout << ans.size();
    for (int i = 0; i < ans.size(); i++) {
      if (i % 10 == 0) {
        cout << "\n";
      }
      cout << ans[i] << " ";
    }
    cout << "\n";
  }
  return 0;
}