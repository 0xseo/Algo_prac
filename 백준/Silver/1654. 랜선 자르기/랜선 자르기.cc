#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;
bool canMakeN(long long len, long long lans[], int K, int N) {
  int cnt = 0;
  for (int i = 0; i < K; i++) {
    cnt += lans[i] / len;
  }
  if (cnt >= N) return true;
  return false;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int K, N;
  cin >> K >> N;

  long long lans[K];
  for (int i = 0; i < K; i++) {
    cin >> lans[i];
  }
  sort(lans, lans+K);

  long long curLen = *max_element(lans, lans+K);
  long long mid;
  long long l = 1;
  long long r = curLen;

  while (l <= r) {
    mid = (l + r) / 2;
    if (canMakeN(mid, lans, K, N)) l = mid + 1;
    else r = mid - 1;
  }

  cout << r << "\n";
  

  return 0;
}