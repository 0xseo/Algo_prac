#include <iostream>
#include <string>
#include <vector>
#include <cmath>

using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int T;
  cin >> T;

  // vector<bool> primeNum;
  bool primeNum[1000001] = {false};
  for (int i = 1; i < 1000001; i++) primeNum[i] = true;

  for (int j = 2; j < sqrt(1000001); j++) {
      if (primeNum[j-1]) {
        int temp = 2 * j;
        while (temp <= 1000001) {
          primeNum[temp-1] = false;
          temp += j;
        }
      }
    }

  for (int i = 0; i < T; i++) {
    int N;
    cin >> N;
    
    if (N == 4) cout << "1\n";
    else {
      int cnt = 0;
      for (int j = 3; j <= N/2; j = j + 2) {
        if (primeNum[j-1] && primeNum[N-j-1]) cnt++;
      }
      cout << cnt << "\n";
    }
    

  }

  return 0;
}