#include <iostream>
#include <vector>

using namespace std;


int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int n;
  long long s;
  cin >> n >> s;

  vector<int> arr(n+1);
  vector<long long> cuSum(n+1);
  for (int i = 1; i <= n; i++) {
    cin >> arr[i];
    cuSum[i] = cuSum[i-1] + arr[i];
  }

  int p1 = 0;
  int p2 = 1;
  int minLength = n+1;

  while (p1 <= p2 && p2 <= n && p1 <= n) {
    if (cuSum[p2] - cuSum[p1] < s) p2++;
    else if (cuSum[p2] - cuSum[p1] > s) {
      minLength = minLength < p2 - p1 ? minLength : p2 - p1;
      p1++;
    }
    else {
      // minLength = min(minLength, p2-p1)
      minLength = minLength < p2 - p1 ? minLength : p2 - p1;
      p2++;
      p1++;
    }
  }

  if (minLength == n + 1) cout << "0\n";
  else cout << minLength << "\n";
  return 0;
}