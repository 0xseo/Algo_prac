#include <iostream>
#include <vector>
#include <cmath>

using namespace std;


int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int N;
  cin >> N;

  vector<int> primeNumber;
  vector<bool> isPN(N+1, true);
  isPN[0] = false;
  isPN[1] = false;

  for (int i = 2; i <= sqrt(N); (i == 2) ? i++ : i += 2) {
    if (isPN[i]) {
      int mul = i * 2;
      while (mul <= N) {
        isPN[mul] = false;
        mul += i;
      }
    }
  }

  for (int i = 2; i <= N; i++) {
    if (isPN[i]) primeNumber.emplace_back(i);
  }

  vector<int> cuSum(1);
  for (int i = 1; i <= primeNumber.size(); i++) {
    cuSum.emplace_back(cuSum[i-1] + primeNumber[i-1]);
  }

  int p1 = 0;
  int p2 = 1;
  int cnt = 0;

  while (p1 <= p2 && p1 <= primeNumber.size() && p2 <= primeNumber.size()) {
    if (cuSum[p2] - cuSum[p1] < N) p2++;
    else if (cuSum[p2] - cuSum[p1] > N) p1++;
    else {
      cnt++;
      p2++;
      p1++;
    }
  }
  cout << cnt << "\n";
  return 0;
}
