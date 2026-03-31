import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(reader.readLine());
    int N = Integer.parseInt(st.nextToken());
    int[] dp = new int[N+1];

    for (int i = 2; i <= N; i++) {
      int minV = Integer.MAX_VALUE;
      if (i % 2 == 0) minV = Math.min(minV, dp[i/2]);
      if (i % 3 == 0) minV = Math.min(minV, dp[i/3]);
      minV = Math.min(minV, dp[i-1]);

      dp[i] = minV + 1;
    }
    writer.write(dp[N] + "\n");
    writer.flush();
  }
}