import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(reader.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] w = new int[N];
    int[] v = new int[N];
    int[] dp = new int[K+1];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(reader.readLine());
      int weight = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());
      w[i] = weight;
      v[i] = value;
    }

    for (int i = 0; i < N; i++) {
      int weight = w[i];
      int value = v[i];

      for (int turn = K; turn >= weight; turn--) {
        dp[turn] = Math.max(dp[turn], dp[turn-weight]+value);
      }
    }
    writer.write(dp[K]+"\n");
    writer.flush();
  }

}