#include <iostream>
#include <algorithm>

using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int N, M;
  cin >> N;

  int arr[N];
  for (int i = 0; i < N; i++) {
    cin >> arr[i];
  }
  sort(arr, arr+N);

  cin >> M;
  for (int i = 0; i < M; i++) {
    int num;
    cin >> num;

    cout << upper_bound(arr, arr+N, num) - lower_bound(arr, arr+N, num) << " ";
  }
  cout << "\n";

  return 0;
}