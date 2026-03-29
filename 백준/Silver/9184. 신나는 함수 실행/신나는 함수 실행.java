import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  static int[][][] dp;
  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(reader.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    dp = new int[51][51][51];
    while (a != -1 || b != -1 || c != -1) {
      int ans = calc(a, b, c);
      dp[a > 0 ? a : 0][b > 0 ? b : 0][c > 0 ? c : 0] = ans;
      writer.write("w(" + a + ", " + b + ", " + c + ") = " + ans + "\n");

      st = new StringTokenizer(reader.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
    }
    
    writer.flush();
  }

  public static int calc(int a, int b, int c) {
    if (a <= 0 || b <= 0 || c <= 0) return 1;
    if (a > 20 || b > 20 || c > 20) {
      if (dp[20][20][20] != 0) return dp[20][20][20];
      else return dp[20][20][20] = calc(20, 20, 20);
    };
    if (a < b && b < c) {
      int t1 = dp[a][b][c-1] != 0 ? dp[a][b][c-1] : calc(a, b, c-1);
      int t2 = dp[a][b-1][c-1] != 0 ? dp[a][b-1][c-1] : calc(a, b-1, c-1);
      int t3 = dp[a][b-1][c] != 0 ? dp[a][b-1][c] : calc(a, b-1, c);

      return dp[a][b][c] = t1 + t2 - t3;
    } else {
      int t1 = dp[a-1][b][c] != 0 ? dp[a-1][b][c] : calc(a-1, b, c);
      int t2 = dp[a-1][b-1][c] != 0 ? dp[a-1][b-1][c] : calc(a-1, b-1, c);
      int t3 = dp[a-1][b][c-1] != 0 ? dp[a-1][b][c-1] : calc(a-1, b, c-1);
      int t4 = dp[a-1][b-1][c-1] != 0 ? dp[a-1][b-1][c-1] : calc(a-1, b-1, c-1);

      return dp[a][b][c] = t1 + t2 + t3 - t4;
    }

  }

}