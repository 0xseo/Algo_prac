#include <iostream>
using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
    
  int N;
  int M;

  cin >> N >> M;

  int arr[N];
  int dp[N];

  for (int i = 0; i < N; i++) {
    cin >> arr[i];
    if (i == 0) dp[0] = arr[0];
    else dp[i] = dp[i-1] + arr[i];
  }

  for (int i = 0; i < M; i++) {
    int s, e;
    cin >> s >> e;
    cout << dp[e-1] - dp[s-1] + arr[s-1] << "\n";
  }
  return 0;
}