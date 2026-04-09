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

  // bit연산으로 높이 계산
  // (1=2^0:1 / 2=2^1:2 / ~4=2^2:3 / ~8=2^3:4)
  int calcBit = n-1;
  int height = 1;
  int baseLineStart;
  while (calcBit > 0) {
    calcBit >>= 1;
    height++;
  }
  // 실제 arr의 시작, 전체 노드 수의 절반부터
  baseLineStart = pow(2, height-1);
  vector<long long> idxTree(pow(2, height), 0);
  for (int i = baseLineStart; i < baseLineStart + n; i++) {
    cin >> idxTree[i];
  }

  // build tree (밑에서부터 자식 노드 더해가며 트리 완성)
  for (int i = baseLineStart - 1; i > 0; i--) {
    idxTree[i] = idxTree[i*2] + idxTree[i*2+1];
  }

  for (int i = 0; i < m + k; i++) {
    int a, b;
    cin >> a >> b;
    
    if (a == 1) {
      long long c;
      cin >> c;
      int treeIndex = b + baseLineStart - 1;
      idxTree[treeIndex] = c;
      // 트리 수정
      for (int j = 1; j < height; j++) {
        int parentIndex = treeIndex / 2;
        idxTree[parentIndex] = idxTree[2*parentIndex] + idxTree[2*parentIndex+1];
        treeIndex = parentIndex;
      }
    } else {
      int c;
      cin >> c;
      // 합 구하기

      long long sum = 0;
      b = b + baseLineStart - 1;
      c = c + baseLineStart - 1;
      while (b < c) {
        // 시작이 홀수면 (자신을 더하고) 부모의 오른쪽 형제로 이동
        if (b % 2 == 1) {
          sum += idxTree[b];
          b = (b + 1) / 2;
        } else b = b / 2; // 짝수면 부모로 이동

        // 끝이 짝수면 (자신을 더하고) 부모의 왼쪽 형제로 이동
        if (c % 2 == 0) {
          sum += idxTree[c];
          c = c / 2 - 1;
        } else c = (c-1) / 2; // 홀수면 부모로 이동
      }
      if (b == c) sum += idxTree[b];
      cout << sum << "\n";
    }
  }
  return 0;
}