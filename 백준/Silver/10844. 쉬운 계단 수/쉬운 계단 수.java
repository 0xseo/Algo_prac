import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(reader.readLine());
    int N = Integer.parseInt(st.nextToken());
    long[][] dp = new long[N][10];
    for (int i = 0; i < 10; i++) dp[0][i] = 1;
    dp[0][0] = 0;

    for (int len = 1; len < N; len++) {
      for (int lastNum = 0; lastNum < 10; lastNum++) {
        if (lastNum == 0) {
          dp[len][lastNum] = dp[len-1][1] % 1000000000;
        } else if (lastNum == 9) {
          dp[len][lastNum] = dp[len-1][8] % 1000000000;
        } else {
          dp[len][lastNum] = (dp[len-1][lastNum-1] + dp[len-1][lastNum+1]) % 1000000000;
        }
      }
    }

    long sum = 0;
    for (int i = 0; i < 10; i++) {
      sum = (sum + dp[N-1][i]) % 1000000000;
    }
    writer.write(sum + "\n");
    writer.flush();
  }

}
