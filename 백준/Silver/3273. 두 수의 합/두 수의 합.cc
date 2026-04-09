#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int n, x;
  cin >> n;

  vector<int> arr(n);
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }

  sort(arr.begin(), arr.end());

  int p1 = 0;
  int p2 = n-1;
  int cnt = 0;
  cin >> x;

  while (p1 < p2) {
    if (arr[p1] + arr[p2] < x) p1++;
    else if (arr[p1] + arr[p2] > x) p2--;
    else {
      p1++;
      p2--;
      cnt++;
    }
  }
  cout << cnt << "\n";
  return 0;
}