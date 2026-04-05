#include <iostream>
#include <algorithm>

using namespace std;
int b_search(int arr[], int size, int num, int l, int r) {
  int mid = 0;
  while (l <= r) {
    mid = (r + l) / 2;
    if (arr[mid] == num) return mid;
    else if (arr[mid] > num) r = mid-1;
    else l = mid+1;
  }
  return -1;
}
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
    int fIndex = b_search(arr, N, num, 0, N-1);
    if (fIndex == -1) cout << "0\n";
    else cout << "1\n";
  }

  return 0;
}