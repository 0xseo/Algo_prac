#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;


int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int n;
  cin >> n;

  vector<long long> arr(n);
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  sort(arr.begin(), arr.end());

  int p1 = 0;
  int p2 = n-1;

  long long wanted = 8e9;
  vector<long long> ans(2);

  while (p1 < p2) {
    if (abs(arr[p1] + arr[p2]) < abs(wanted))  {
      wanted = arr[p1] + arr[p2];
      ans[0] = arr[p1];
      ans[1] = arr[p2];
      if (wanted > 0) p2--;
      else p1++;
    } else {
      if (arr[p1] + arr[p2] > 0) p2--;
      else p1++;
    }
  }

  cout << ans[0] << " " << ans[1] << "\n";

  return 0;
}