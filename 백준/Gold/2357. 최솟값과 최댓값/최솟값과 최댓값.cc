#include <iostream>
#include <vector>
#include <cmath>

using namespace std;


int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int n, m;
  cin >> n >> m;

  int height = 1;
  int calcBit = n;
  while (calcBit > 0) {
    height++;
    calcBit >>= 1;
  }
  int baseLineStart = pow(2, height - 1);

  long long maxv = 1000000001;
  vector<long long> idxTreeMax(2*baseLineStart, 0);
  vector<long long> idxTreeMin(2*baseLineStart, maxv);
  for (int i = baseLineStart; i < baseLineStart + n; i++) {
    cin >> idxTreeMax[i];
    idxTreeMin[i] = idxTreeMax[i];
  }
  // build tree
  for (int i = baseLineStart - 1; i > 0; i--) {
    idxTreeMax[i] = max(idxTreeMax[i*2], idxTreeMax[i*2+1]);
    idxTreeMin[i] = min(idxTreeMin[i*2], idxTreeMin[i*2+1]);
  }

  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;

    long long minQuery = maxv;
    long long maxQuery = 0;

    a = a + baseLineStart - 1;
    b = b + baseLineStart - 1;

    while (a < b) {
      if (a % 2 == 1) {
        minQuery = min(minQuery, idxTreeMin[a]);
        maxQuery = max(maxQuery, idxTreeMax[a]);
        a = (a + 1) / 2;
      } else a /= 2;
      if (b % 2 == 0) {
        minQuery = min(minQuery, idxTreeMin[b]);
        maxQuery = max(maxQuery, idxTreeMax[b]);
        b = (b - 1) / 2;
      } else b /= 2;
    }
    if (a == b) {
      minQuery = min(minQuery, idxTreeMin[b]);
      maxQuery = max(maxQuery, idxTreeMax[b]);
    }
    cout << minQuery << " " << maxQuery << "\n";
  }
  return 0;
}