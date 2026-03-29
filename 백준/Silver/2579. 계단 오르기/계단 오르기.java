import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] dp1 = new int[n+1];
    int[] dp2 = new int[n+1];
    int[] point = new int[n+1];

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(reader.readLine());
      int p = Integer.parseInt(st.nextToken());
      point[i] = p;
    }

    dp1[1] = point[1];
    dp2[1] = point[1];

    for (int i = 2; i <= n; i++) {
      dp1[i] = dp2[i-1] + point[i];
      dp2[i] = Math.max(dp1[i-2], dp2[i-2]) + point[i];
    }
    writer.write(Math.max(dp1[n], dp2[n]) + "\n");
    writer.flush();
  }

}