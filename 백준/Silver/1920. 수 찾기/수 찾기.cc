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
    bool isIn = binary_search(arr, arr+N, num);
    if (isIn) cout << "1\n";
    else cout << "0\n";
  }

  return 0;
}