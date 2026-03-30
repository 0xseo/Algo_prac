import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    long[] dp1 = new long[n];
    long[] dp2 = new long[n];
    long[] dp3 = new long[n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(reader.readLine());
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dp1[0] = arr[0];
    dp2[0] = arr[0];
    for (int i = 1; i < n; i++) {
      dp1[i] = dp2[i-1] + arr[i];
      if (i == 1) {
        dp2[i] = arr[i];
      } else {
        dp2[i] = Math.max(Math.max(dp1[i-2], dp2[i-2]), dp3[i-1])+arr[i];
      }
      dp3[i] = Math.max(Math.max(dp1[i-1], dp2[i-1]), dp3[i-1]);
    }

    long maxV = dp1[0];
    for (int i = 0; i < n; i++) {
      maxV = Math.max(Math.max(maxV, dp1[i]), Math.max(dp2[i], dp3[i]));
    }
    writer.write(maxV + "\n");
    writer.flush();
  }
}