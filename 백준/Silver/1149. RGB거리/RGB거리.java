import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(reader.readLine());
    int N = Integer.parseInt(st.nextToken());

    int[] red = new int[N];
    int[] green = new int[N];
    int[] blue = new int[N];
    int[][] cost = new int[N][3];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(reader.readLine());
      int r = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      cost[i][0] = r;
      cost[i][1] = g;
      cost[i][2] = b;
    }

    red[0] = cost[0][0];
    green[0] = cost[0][1];
    blue[0] = cost[0][2];

    for (int i = 1; i < N; i++) {
      red[i] = Math.min(green[i-1], blue[i-1]) + cost[i][0];
      green[i] = Math.min(red[i-1], blue[i-1]) + cost[i][1];
      blue[i] = Math.min(red[i-1], green[i-1]) + cost[i][2];
    }

    writer.write(Math.min(Math.min(red[N-1], green[N-1]), blue[N-1]) + "\n");

    writer.flush();
  }

}