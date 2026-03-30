import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(reader.readLine());
    int N = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
    int[] dp = new int[N];
    int res = 0;
    st = new StringTokenizer(reader.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          dp[i] = Math.max(dp[i], dp[j]+1);
        }
      }
      res = Math.max(res, dp[i]);
    }

    writer.write(res + "\n");

    writer.flush();
  }

}
