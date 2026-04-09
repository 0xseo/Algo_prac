#include <iostream>
#include <vector>
#include <cmath>

using namespace std;


int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int n, m, k;
  cin >> n >> m >> k;

  int calcBit = n-1;
  int height = 1;
  while (calcBit > 0) {
    calcBit >>= 1;
    height++;
  }
  int baseLineStart = pow(2, height-1);
  long long mod = 1000000007;

  vector<long long> idxTree(baseLineStart * 2);
  for (int i = baseLineStart; i < baseLineStart + n; i++) {
    cin >> idxTree[i];
  }

  // build tree
  for (int i = baseLineStart - 1; i > 0; i--) {
    idxTree[i] = (idxTree[i*2] % mod) * (idxTree[i*2+1] % mod) % mod;
  }

  for (int i = 0; i < m+k; i++) {
    int a, b;
    cin >> a >> b;
    if (a == 1) {
      long long c;
      cin >> c;

      int index = b + baseLineStart - 1;
      idxTree[index] = c;
      // 트리 수정
      for (int j = 1; j < height; j++) {
        int parentIndex = index / 2;
        idxTree[parentIndex] = (idxTree[parentIndex*2] % mod) * (idxTree[parentIndex*2+1] % mod) % mod;
        index = parentIndex;
      }
    } else {
      int c;
      cin >> c;

      b = b + baseLineStart - 1;
      c = c + baseLineStart - 1;
      long long mult = 1;
      while (b < c) {
        if (b % 2 == 1) {
          mult = mult * (idxTree[b] % mod) % mod;
          b = (b+1) / 2;
        } else b /= 2;
        if (c % 2 == 0) {
          mult = mult * (idxTree[c] % mod) % mod;
          c = (c-1) / 2;
        } else c /= 2;
      }
      if (b == c) mult = mult * (idxTree[b] % mod) % mod;
      cout << mult % mod << "\n";
    }
  }
  return 0;
}